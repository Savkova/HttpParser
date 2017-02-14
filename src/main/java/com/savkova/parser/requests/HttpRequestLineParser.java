package com.savkova.parser.requests;

public class HttpRequestLineParser {

    public HttpRequestLine parse(String inputLine) {

        String[] requestLineSplitOnSpace = inputLine.split(" ");

        String method = requestLineSplitOnSpace[0];
        String uriWithParam = requestLineSplitOnSpace[1];
        String protocolVersion = requestLineSplitOnSpace[2];

        String uri = uriWithParam.substring( 0, uriWithParam.indexOf('?') );
        String param = uriWithParam.substring(uriWithParam.indexOf('?')+1);

        return new HttpRequestLine(method, protocolVersion,uri, param);
    }

}
