package com.savkova.parser.requests;

import static org.junit.Assert.*;

public class HttpRequestParserTest extends HttpRequestParser {
    final String message = "GET /recordpoint?lat=1234&lon=5678&t=12:00 HTTP/1.1\n" +
            "Host: 192.168.0.120:9090\n" +
            "Connection: Keep-Alive\n" +
            "User-Agent: Apache-HttpClient/4.5.2 (Java/1.8)\n" +
            "Accept-Encoding: gzip,deflate\n\n" +
            "Some important info";

    @org.junit.Test
    public void parse() throws Exception {

        HttpRequestParser httpRequestParser = new HttpRequestParser();
        MyHttpRequest myHttpRequest = httpRequestParser.parse(message);

        assertNotNull("MyHttpRequest created.", myHttpRequest);

        String expectedResult = "GET";
        String actualResult = myHttpRequest.getRequestLine().getMethod();
        assertEquals(expectedResult, actualResult);

        expectedResult = "/recordpoint";
        actualResult = myHttpRequest.getRequestLine().getUri();
        assertEquals(expectedResult, actualResult);

        expectedResult = "HTTP/1.1";
        actualResult = myHttpRequest.getRequestLine().getProtocolVersion();
        assertEquals(expectedResult, actualResult);

        expectedResult = "Some important info";
        actualResult = myHttpRequest.getBody();
        assertEquals(expectedResult, actualResult);

        expectedResult = "192.168.0.120:9090";
        actualResult = myHttpRequest.getHeaders().get("Host");
        assertEquals(expectedResult, actualResult);

    }

}