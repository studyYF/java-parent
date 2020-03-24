package com.crossyf.practice.nativetomcat;

import com.crossyf.practice.nativetomcat.http.DefaultRequest;
import com.crossyf.practice.nativetomcat.http.DefaultResponse;
import com.crossyf.practice.nativetomcat.servlet.AbstractServlet;
import com.sun.corba.se.internal.CosNaming.BootstrapServer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.util.concurrent.EventExecutorGroup;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author Created by crossyf.
 * @date 2020/3/21
 * 功能:
 */
public class NativeTomcat {
    /*
     * 利用Java原生socket实现简单的tomcat步骤
     * 服务端：
     * 1. 读取配置文件信息，生成servletMapping
     * 2. 启动ServerSocket，监听客户端连接
     * 3. 获取InputStream，解析请求数据，封装Request和Response
     * 4. 处理请求，将response返回
     * */


    private int port;
    private ServerSocket serverSocket;
    private Properties properties = new Properties();
    private Map<String, AbstractServlet> servletMapping = new HashMap<>();

    public NativeTomcat(int port) {
        this.port = port;
        this.init();
    }


    private void init() {
        InputStream resource = null;
        try {
            resource = this.getClass().getClassLoader().getResourceAsStream("web.properties");
            properties.load(resource);
            for (Object o : properties.keySet()) {
                String key = o.toString();
                if (key.endsWith(".url")) {
                    String servletNameKey = key.substring(0,key.length()-3) + "className";
                    String servletName = properties.getProperty(servletNameKey);
                    try {
                        AbstractServlet servlet = (AbstractServlet)Class.forName(servletName).newInstance();
                        servletMapping.put(properties.getProperty(key),servlet);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }

        } catch (IOException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            if (resource != null) {
                try {
                    resource.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private void start() {
        //使用netty的方式
        BootstrapServer bootstrapServer = new BootstrapServer();
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new HttpResponseEncoder());
                            socketChannel.pipeline().addLast(new HttpRequestDecoder());
                            socketChannel.pipeline().addLast(new TomcatHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG,128)
                    .childOption(ChannelOption.SO_KEEPALIVE,true);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
//        try {
//            serverSocket = new ServerSocket(this.port);
//            while (true) {
//                Socket socket = serverSocket.accept();
//                this.process(socket);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    private void process(Socket socket) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = socket.getInputStream();
            DefaultRequest request = new DefaultRequest(inputStream);
            outputStream = socket.getOutputStream();
            DefaultResponse response = new DefaultResponse(outputStream);
            AbstractServlet servlet = servletMapping.get(request.getUrl());
            if (servlet != null) {
                servlet.service(request,response);
            }
            outputStream.flush();
            inputStream.close();
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new NativeTomcat(8011).start();
    }


    private class TomcatHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {


            System.out.println(msg);
        }
    }
}
