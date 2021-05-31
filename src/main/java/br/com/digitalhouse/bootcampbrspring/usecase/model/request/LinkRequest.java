package br.com.digitalhouse.bootcampbrspring.usecase.model.request;

public class LinkRequest {

    private String uri;

    public LinkRequest() {
    }

    public LinkRequest(String uri) {
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
