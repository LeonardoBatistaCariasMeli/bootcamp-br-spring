package br.com.digitalhouse.bootcampbrspring.usecase.model.response;

import java.util.UUID;

public class LinkResponse {

    private UUID id;
    private String uri;
    private boolean active;

    public LinkResponse() {
        this.active = true;
    }

    public LinkResponse(UUID id, String uri) {
        this.id = id;
        this.uri = uri;
        this.active = true;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
