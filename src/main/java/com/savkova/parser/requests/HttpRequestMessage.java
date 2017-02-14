package com.savkova.parser.requests;

import com.savkova.parser.httpMessages.HttpMessage;

public interface HttpRequestMessage extends HttpMessage {
    HttpRequestLine getRequestLine();
}
