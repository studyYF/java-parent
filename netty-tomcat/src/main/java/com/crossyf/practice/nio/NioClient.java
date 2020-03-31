package com.crossyf.practice.nio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author Created by crossyf.
 * @date 2020/3/29
 * 功能:
 */
public class NioClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",8888);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("nihao".getBytes());
        outputStream.flush();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int read = inputStream.read(bytes);
        if (read > 0) {
            String result = new String(bytes,0,read);
            System.out.println("收到服务器返回" + result);
        }
    }
}
