package com.savkova.parser.requests;

import com.savkova.parser.HttpMessage;

public interface MyHttpRequestMessage extends HttpMessage {
    MyHttpRequestLine getRequestLine();
}
