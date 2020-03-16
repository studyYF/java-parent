package com.crossyf.practice.java.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Created by crossyf.
 * @date 2020/3/15
 * 功能:
 */
public class SocketServer {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8044);
            //这句代码会出现阻塞，如果没有客户端连接，则会一直阻塞
            Socket accept = serverSocket.accept();
            //这里也会有阻塞，因为
            InputStream inputStream = accept.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter printWriter = new PrintWriter(accept.getOutputStream());
            String line = reader.readLine();
            System.out.println(line);
//            inputStream.close();
            printWriter.write(line + " 哈哈");
            printWriter.flush();
//            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            try {
////                serverSocket.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }
}
