package com.crossyf.practice.java.socket;

import java.io.*;
import java.net.Socket;

/**
 * @author Created by crossyf.
 * @date 2020/3/16
 * 功能:
 */
public class SocketClient {

    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("localhost",8033);
            OutputStream outputStream = socket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.write("crossyf hello");
            printWriter.flush();
            printWriter.close();
            System.out.println(reader.readLine());
//            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            try {
//                socket.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }
}
