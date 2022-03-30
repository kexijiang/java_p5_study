package com.kxjiang.java_p5_study.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author kxjiang
 * @date 2022-03-31 0:03
 */
@SuppressWarnings("all")
public class NIOSocketClient01Example {
    public static void main(String[] args) {
        try{
            SocketChannel socketChannel = SocketChannel.open();
            // 设置为非阻塞
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress(8080));
            if(socketChannel.isConnectionPending()){
                socketChannel.finishConnect();
            }
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.put("hello, I am client01".getBytes(StandardCharsets.UTF_8));
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
            // 进行读取
            buffer.flip();
            ByteBuffer bf = ByteBuffer.allocate(1024);
            while(true){
                int r = socketChannel.read(bf);
                if(r>0){
                    System.out.println("收到服务端消息："+new String(bf.array(),0,bf.position()));
                }else{
                    Thread.sleep(1000);
                    System.out.println("服务端还未有消息返回！");
                }
            }


        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }
}
