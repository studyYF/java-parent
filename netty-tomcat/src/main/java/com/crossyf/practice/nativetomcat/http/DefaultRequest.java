package com.crossyf.practice.nativetomcat.http;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Created by crossyf.
 * @date 2020/3/21
 * 功能:
 */
public class DefaultRequest {

    private InputStream inputStream;

    private String url;
    private String method;

    public DefaultRequest(InputStream inputStream) {
        this.inputStream = inputStream;

        try {
            byte[] bytes = new byte[1024];
            int read = inputStream.read(bytes);
            if (read > 0) {
                String content = new String(bytes,0,read);
//                GET /firstServlet.do HTTP/1.1
//                System.out.println(content);
                String firstLine = content.split("\\n")[0];
                String[] arr = firstLine.split("\\s");
                this.url = arr[1];
                this.method = arr[0];
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
