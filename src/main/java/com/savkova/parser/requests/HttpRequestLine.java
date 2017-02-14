package com.savkova.parser.requests;

public class HttpRequestLine {

    private String method;
    private String protocolVersion;
    private String uri;
    private String params; // map


    public HttpRequestLine(String method, String protocolVersion, String uri, String params) {
        this.method = method;
        this.protocolVersion = protocolVersion;
        this.uri = uri;
        this.params = params;
    }

    public String getMethod() {
        return method;
    }

    public String getProtocolVersion() {
        return protocolVersion;
    }

    public String getUri() {
        return uri;
    }

    public String getParams() {
        return params;
    }

    @Override
    public String toString() {
        return "HttpRequestLine{" +
                "method:'" + method + '\"' +
                ", protocolVersion:'" + protocolVersion + '\"' +
                ", uri:'" + uri + '\"' +
                ", params:'" + params + '\"' +
                '}';
    }
}
