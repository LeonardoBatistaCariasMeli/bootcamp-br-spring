package br.com.digitalhouse.bootcampbrspring.usecase.model.response;

import br.com.digitalhouse.bootcampbrspring.usecase.model.request.LinkRequest;

import java.util.UUID;

public class LinkResponse {

    private UUID id;
    private String name;
    private String uri;
    private String protocol;
    private String host;
    private String endpoint;
    private boolean active;

    public LinkResponse() {
        this.id = UUID.randomUUID();
        this.active = true;
    }

    public LinkResponse(String name, String uri, String protocol, String host, String endpoint) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.uri = uri;
        this.protocol = protocol;
        this.host = host;
        this.endpoint = endpoint;
        this.active = true;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
