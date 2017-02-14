package com.savkova.parser.requests;

import java.util.HashMap;

public class HttpRequestParser {

    public HttpRequestLineParser httpRequestLineParser;

    public HttpRequestParser() {
        this.httpRequestLineParser = new HttpRequestLineParser();
    }

    public HttpRequest parse(String inputRequest) {
        String[] httpRequestSplitByNewLine = inputRequest.split("\n");

        String requestLine = httpRequestSplitByNewLine[0];

        HashMap<String, String> headers = new HashMap<String, String>();
        String headerName = "";
        String headerValue = "";
        int indexOfColon = -1;
        String body = "";



        for (int i = 1; i < httpRequestSplitByNewLine.length; i++) {

            if (httpRequestSplitByNewLine[i].equals("")) {
                body = httpRequestSplitByNewLine[i+1];
                break;
            }

                indexOfColon = httpRequestSplitByNewLine[i].indexOf(":");
                headerName = httpRequestSplitByNewLine[i].substring(0, indexOfColon);
                headerValue = httpRequestSplitByNewLine[i].substring(indexOfColon + 2);
                headers.put(headerName, headerValue);
        }

        return new HttpRequest(this.httpRequestLineParser.parse(requestLine), headers, body);

    }
}
