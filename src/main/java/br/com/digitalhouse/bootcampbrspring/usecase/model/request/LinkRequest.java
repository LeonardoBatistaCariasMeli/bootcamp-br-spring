package br.com.digitalhouse.bootcampbrspring.usecase.model.request;

public class LinkRequest {

    private String name;
    private String protocol;
    private String host;
    private String endpoint;

    public LinkRequest() {
    }

    public LinkRequest(String name, String protocol, String host, String endpoint) {
        this.name = name;
        this.protocol = protocol;
        this.host = host;
        this.endpoint = endpoint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
