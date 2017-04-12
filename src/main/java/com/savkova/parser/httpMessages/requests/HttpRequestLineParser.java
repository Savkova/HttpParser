package com.savkova.parser.httpMessages.requests;

import java.util.*;

class HttpRequestLineParser {

    HttpRequestLineParser() {
    }

    MyHttpRequestLine parse(String inputLine) {
        String[] requestLineSplitOnSpace = inputLine.split(" ");

        String method = requestLineSplitOnSpace[0];
        String protocolVersion = requestLineSplitOnSpace[2];

        String uriWithParam = requestLineSplitOnSpace[1];
        String uri = uriWithParam.substring(0, uriWithParam.indexOf('?'));

        String paramLine = uriWithParam.substring(uriWithParam.indexOf('?') + 1);
        String[] keyValuePairs = paramLine.split("&");
        Map<String, String> params = new HashMap<>();
        for (String pair : keyValuePairs) {
            String[] entry = pair.split("=");
            params.put(entry[0], entry[1]);
        }

        return new MyHttpRequestLine(method, protocolVersion, uri, params);
    }

}
