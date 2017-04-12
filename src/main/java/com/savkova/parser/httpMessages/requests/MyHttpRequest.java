package com.savkova.parser.httpMessages.requests;

import java.util.Map;

public class MyHttpRequest implements MyHttpRequestMessage {
    private MyHttpRequestLine requestLine;
    private Map<String, String> headers;
    private String body;

    MyHttpRequest(MyHttpRequestLine requestLine) {
        this.requestLine = requestLine;
    }

    MyHttpRequest(MyHttpRequestLine requestLine, Map<String, String> headers, String body) {
        this.requestLine = requestLine;
        this.headers = headers;
        this.body = body;
    }

    public MyHttpRequestLine getRequestLine() {
        return requestLine;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }

    public String getProtocolVersion() {
        return requestLine.getProtocolVersion();
    }
}
