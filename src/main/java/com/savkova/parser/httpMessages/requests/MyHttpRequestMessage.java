package com.savkova.parser.httpMessages.requests;

import com.savkova.parser.httpMessages.HttpMessage;

public interface MyHttpRequestMessage extends HttpMessage {
    MyHttpRequestLine getRequestLine();
}
