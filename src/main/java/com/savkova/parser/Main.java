package com.savkova.parser;

import com.savkova.parser.requests.MyHttpRequest;
import com.savkova.parser.requests.HttpRequestParser;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        final String requestLine = "GET /recordpoint?lat=1234&lon=5678&t=12:00";

        final String protocolVersion = "HTTP/1.1";

        final String headers = "Host: 192.168.0.120\n" +
                "Connection: Keep-Alive\n" +
                "User-Agent: Apache-HttpClient/4.5.2 (Java/1.8)\n" +
                "Accept-Encoding: gzip,deflate";

        final String body = "Some important info";

        final String message = requestLine + " " + protocolVersion + "\n" + headers + "\n\n" + body;

        HttpRequestParser httpRequestParser = new HttpRequestParser();

        MyHttpRequest myHttpRequest = httpRequestParser.parse(message);

        System.out.print(myHttpRequest.getRequestLine().getMethod() + " ");
        System.out.print(myHttpRequest.getRequestLine().getUri() + " ");
        System.out.println(myHttpRequest.getRequestLine().getProtocolVersion());
        for (Map.Entry<String, String> entry : myHttpRequest.getHeaders().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
        System.out.println(myHttpRequest.getBody());
    }

}
