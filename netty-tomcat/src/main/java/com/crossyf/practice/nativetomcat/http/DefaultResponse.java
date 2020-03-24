package com.crossyf.practice.nativetomcat.http;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Created by crossyf.
 * @date 2020/3/21
 * 功能:
 */

public class DefaultResponse {

    private OutputStream outputStream;

    public DefaultResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void write(String string) {
        try {
            StringBuilder responseString = new StringBuilder();
            responseString.append("HTTP/1.1 200 OK");
            responseString.append("\n");
            responseString.append("Content-Type: text/html;");
            responseString.append("\n\r\n");
            responseString.append(string);
            outputStream.write(responseString.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
