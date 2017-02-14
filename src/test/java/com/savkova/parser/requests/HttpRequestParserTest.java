package com.savkova.parser.requests;

import static org.junit.Assert.*;

public class HttpRequestParserTest extends HttpRequestParser {
    final String message = "GET /recordpoint?lat=1234&lon=5678&t=12:00 HTTP/1.1\n" +
            "Host: 192.168.0.120:9090\n" +
            "Connection: Keep-Alive\n" +
            "User-Agent: Apache-HttpClient/4.5.2 (Java/1.8.0_91)\n" +
            "Accept-Encoding: gzip,deflate\n\n" +
            "BODY";

    @org.junit.Test
    public void parse() throws Exception {

        HttpRequestParser httpRequestParser = new HttpRequestParser();
        HttpRequest httpRequest = httpRequestParser.parse(message);

        assertNotNull("HttpRequest created.", httpRequest);

        String expectedResult = "GET";
        String actualResult = httpRequest.getRequestLine().getMethod();
        assertEquals(expectedResult, actualResult);

        expectedResult = "/recordpoint";
        actualResult = httpRequest.getRequestLine().getUri();
        assertEquals(expectedResult, actualResult);

        expectedResult = "HTTP/1.1";
        actualResult = httpRequest.getRequestLine().getProtocolVersion();
        assertEquals(expectedResult, actualResult);
    }

}