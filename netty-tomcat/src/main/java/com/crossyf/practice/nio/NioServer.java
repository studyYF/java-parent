package com.crossyf.practice.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Created by crossyf.
 * @date 2020/3/29
 * 功能: 基于NIO实现服务端
 */
public class NioServer {

    private int port;
    private Selector selector;
    private ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

    public NioServer(int port) {
        this.port = port;
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            selector = Selector.open();
            serverSocketChannel.bind(new InetSocketAddress(port));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void listen() {
        try {
            while (true){
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    this.process(key);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void process(SelectionKey key) {
        //表示接收到客户端的连接，设置key为可读
        if (key.isAcceptable()) {
            try {
                ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
                SocketChannel accept = serverSocketChannel.accept();
                accept.configureBlocking(false);
                accept.register(selector,SelectionKey.OP_READ);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if(key.isReadable()) {
            //表示接收到客户端发送的数据，解析
            try {
                SocketChannel socketChannel = (SocketChannel) key.channel();
                int read = socketChannel.read(byteBuffer);
                if (read > 0) {
                    byteBuffer.flip();
                    String content = new String(byteBuffer.array(),0,read);
                    System.out.println(content);
                    //将内容写回去
                    socketChannel.register(selector, SelectionKey.OP_WRITE);
                    key.attach(content + "，收到");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if(key.isWritable()) {
            //表示读取完毕，可以将数据写回客户端
            try {
                SocketChannel socketChannel = (SocketChannel) key.channel();
                String back = (String) key.attachment();
                socketChannel.write(ByteBuffer.wrap(back.getBytes()));
                socketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        new NioServer(8888).listen();
    }
}
