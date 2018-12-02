package com.savkova.parser;

import com.savkova.parser.requests.MyHttpRequest;
import com.savkova.parser.requests.HttpRequestParser;

public class Main {

    public static void main(String[] args) {
        final String requestLine = "GET /recordpoint?lat=1234&lon=5678&t=12:00 HTTP/1.1";

        final String protocolVersion = "HTTP/1.1";

        final String headers = "Host: 192.168.0.120:9090\n" +
                "Connection: Keep-Alive\n" +
                "User-Agent: Apache-HttpClient/4.5.2 (Java/1.8.0_91)\n" +
                "Accept-Encoding: gzip,deflate";

        final String body = "Some impotent info";

        final String message = requestLine + " " + protocolVersion + "\n" + headers + "\n\n" + body;

        HttpRequestParser httpRequestParser = new HttpRequestParser();

        MyHttpRequest myHttpRequest = httpRequestParser.parse(message);

        System.out.println(myHttpRequest.getRequestLine());
        System.out.println(myHttpRequest.getProtocolVersion());
        System.out.println(myHttpRequest.getHeaders());
        System.out.println(myHttpRequest.getBody());
    }

}
