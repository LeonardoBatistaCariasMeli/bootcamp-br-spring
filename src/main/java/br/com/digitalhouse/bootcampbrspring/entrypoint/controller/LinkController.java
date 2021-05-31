package br.com.digitalhouse.bootcampbrspring.entrypoint.controller;

import br.com.digitalhouse.bootcampbrspring.usecase.model.request.LinkRequest;
import br.com.digitalhouse.bootcampbrspring.usecase.model.response.LinkResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URL;
import java.util.*;

@RestController
@RequestMapping(value = "/link")
public class LinkController {

    public static List<LinkResponse> links = new ArrayList<>();
    public static Map<UUID, Integer> metrics = new HashMap<>();

    @PostMapping
    public ResponseEntity<LinkResponse> createLink(@RequestBody LinkRequest request){
        var uri = request.getProtocol() + "://" + request.getHost() + "/" + request.getEndpoint();

        if (!validateUri(uri)) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        var response = new LinkResponse(request.getName(), uri, request.getProtocol(), request.getHost(), request.getEndpoint());

        links.add(response);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/{linkId}")
    public ResponseEntity validateLink(@PathVariable UUID linkId){
        var link = links.stream().filter(l -> l.getId().equals(linkId)).findFirst();

        if (link.isEmpty() || !validateUri(link.get().getUri())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        link.get().setActive(!link.get().isActive());

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public ResponseEntity<List<LinkResponse>> getLinks(){
        if (links.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(links, HttpStatus.OK);
    }

    @GetMapping("/{linkId}")
    public ResponseEntity<Object> getLinks(@PathVariable UUID linkId){
        var link = links.stream().filter(l -> l.getId().equals(linkId)).findFirst();

        if (link.isEmpty() || !validateUri(link.get().getUri())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        if (!link.get().isActive()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        addMetrics(linkId);

        return ResponseEntity.status(HttpStatus.PERMANENT_REDIRECT).location(URI.create(link.get().getUri())).build();
    }

    @GetMapping("/metrics")
    public ResponseEntity<Map<UUID, Integer>> getMetrics(){
        return new ResponseEntity(metrics, HttpStatus.OK);
    }

    @GetMapping("/metric/{linkId}")
    public ResponseEntity<Object> getMetric(@PathVariable UUID linkId){
        var metric = metrics.get(linkId);

        if (metric == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return new ResponseEntity<>(metric, HttpStatus.OK);
    }

    private void addMetrics(UUID id) {
        var value = metrics.getOrDefault(id, 0);

        metrics.put(id, ++value);
    }

    private boolean validateUri(String uri) {
        final URL url;

        try {
            url = new URL(uri);
        } catch (Exception ex) {
            return false;
        }

        return "http".equals(url.getProtocol()) || "https".equals(url.getProtocol());
    }
}
