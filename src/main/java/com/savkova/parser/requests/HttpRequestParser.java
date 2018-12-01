package com.savkova.parser.requests;

import java.util.*;

public class HttpRequestParser {

    private HttpRequestLineParser httpRequestLineParser;

    public HttpRequestParser() {
        this.httpRequestLineParser = new HttpRequestLineParser();
    }

    public MyHttpRequest parse(String inputRequest) {
        String[] httpRequestSplitByNewLine = inputRequest.split("\n");

        String requestLine = httpRequestSplitByNewLine[0];
        Map<String, String> headers = new HashMap<>();
        String body = "";
        String emptyLine = "";

        for (int i = 1; i < httpRequestSplitByNewLine.length; i++) {

            if (httpRequestSplitByNewLine[i].equals(emptyLine)) {
                body = httpRequestSplitByNewLine[i + 1];
                break;
            }

            String[] entry = httpRequestSplitByNewLine[i].split(":");
            headers.put(entry[0].trim(), entry[1].trim());
        }

        return new MyHttpRequest(this.httpRequestLineParser.parse(requestLine), headers, body);
    }
}
