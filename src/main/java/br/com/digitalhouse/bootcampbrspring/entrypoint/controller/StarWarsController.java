package br.com.digitalhouse.bootcampbrspring.entrypoint.controller;

import br.com.digitalhouse.bootcampbrspring.usecase.StarWarsUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/star-wars")
public class StarWarsController {

    private StarWarsUseCase starWarsUseCase;

    public StarWarsController(StarWarsUseCase starWarsUseCase) {
        this.starWarsUseCase = starWarsUseCase;
    }

    @GetMapping
    public ResponseEntity<List<String>> getAllCharactersByName(@RequestParam String name) {
        var listNames = this.starWarsUseCase.getAllCharactersByName(name);
        return ResponseEntity.ok().body(listNames);
    }

}
