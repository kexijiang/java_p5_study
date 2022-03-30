package com.kxjiang.java_p5_study.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author kxjiang
 * @date 2022-03-30 23:59
 */
@SuppressWarnings("all")
public class NIOSocketServer01Example {
    public static void main(String[] args) {
        try{
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            // 设置为非阻塞
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(8080));
            while(true){
                SocketChannel socketChannel = serverSocketChannel.accept();// 如果不设置非阻塞 默认还是阻塞的
                if(socketChannel!=null){
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    socketChannel.read(buffer);
                    System.out.println(new String(buffer.array(),0,buffer.position()));
                    buffer.flip();
                    // 睡眠10秒，在写回数据
                    Thread.sleep(10000);
                    buffer.clear();
                    ByteBuffer bf = ByteBuffer.allocate(1024);

                    bf.put("你好，我是服务端，我已经收到你的消息！".getBytes(StandardCharsets.UTF_8));
                    buffer.flip();
                    socketChannel.write(bf);
                }else{
                    Thread.sleep(1000);
                    System.out.println("没有客户端连接过来");
                }

            }
        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }
}
