package com.savkova.parser.requests;

import java.util.Map;

public class HttpRequest implements HttpRequestMessage {

    private HttpRequestLine requestLine;
    private Map<String, String> headers;
    private String body;

    public HttpRequest(HttpRequestLine requestLine) {
        this.requestLine = requestLine;
    }

    public HttpRequest(HttpRequestLine requestLine, Map<String, String> headers, String body) {
        this.requestLine = requestLine;
        this.headers = headers;
        this.body = body;
    }

    public HttpRequestLine getRequestLine() {
        return requestLine;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getProtocolVersion() {
        return requestLine.getProtocolVersion();
    }
}
