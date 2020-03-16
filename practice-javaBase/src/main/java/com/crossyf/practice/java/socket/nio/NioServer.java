package com.crossyf.practice.java.socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Created by crossyf.
 * @date 2020/3/16
 * 功能:
 */
public class NioServer {

    private int port = 8033;

    private Selector selector;

    private ByteBuffer byteBuffer = ByteBuffer.allocate(1024);


    public NioServer(int port) throws IOException {
        this.port = port;
        //1.
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.bind(new InetSocketAddress(this.port));
        socketChannel.configureBlocking(false);

        //2.
        selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_ACCEPT);

    }


    private void listen() {
        try {
            while (true) {
                selector.select();
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = keys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    process(key);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    private void process(SelectionKey key) throws IOException {
        if (key.isAcceptable()){
            ServerSocketChannel channel = (ServerSocketChannel) key.channel();
            SocketChannel socketChannel = channel.accept();
            socketChannel.configureBlocking(false);
            socketChannel.register(selector,SelectionKey.OP_READ);
        }
        else if(key.isReadable()) {
            SocketChannel channel = (SocketChannel) key.channel();
            int read = channel.read(byteBuffer);
            if (read > 0) {
                byteBuffer.flip();
                String content = new String(byteBuffer.array(),0,read);
                System.out.printf("内容：" + content);
                key = channel.register(selector,SelectionKey.OP_WRITE);
                key.attach(content);
            }
        }
        else if (key.isWritable()) {
            SocketChannel channel = (SocketChannel) key.channel();
            String content = (String) key.attachment();
            System.out.println("写的内容：" + content);
            channel.write(ByteBuffer.wrap(content.getBytes()));
            channel.close();
        }
    }

    public static void main(String[] args) {
        try {
            NioServer nioServer = new NioServer(8033);
            nioServer.listen();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
