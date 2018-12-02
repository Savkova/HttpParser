package com.savkova.parser.requests;

import java.util.Map;

public class MyHttpRequestLine {

    private String method;
    private String protocolVersion;
    private String uri;
    private Map<String, String> params;


    MyHttpRequestLine(String method, String protocolVersion, String uri, Map<String, String> params) {
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

    public Map<String, String> getParams() {
        return params;
    }

    @Override
    public String toString() {
        return "MyHttpRequestLine{" +
                "method:'" + method + '\'' +
                ", protocolVersion:'" + protocolVersion + '\'' +
                ", uri:'" + uri + '\'' +
                ", params:'" + params + '\'' +
                '}';
    }
}

