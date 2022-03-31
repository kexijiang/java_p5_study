package com.kxjiang.java_p5_study.io.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * @author kxjiang
 * @date 2022-03-31 23:14
 */
@SuppressWarnings("all")
public class NIOSelectorClient01 {
    private static Selector selector;
    public static void main(String[] args) throws IOException {
        selector = Selector.open();
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);// 设置连接非阻塞
        socketChannel.connect(new InetSocketAddress(8080));

        // 注册连接事件
        socketChannel.register(selector,SelectionKey.OP_CONNECT);

        try{
            while(true){
                // 此处会阻塞,如果有连接进来就会返回，不阻塞
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()){
                    SelectionKey selectionKey = iterator.next();
                    iterator.remove();
                    // 连接事件 发起连接成功
                    if(selectionKey.isConnectable()){
                        handleConnectable(selectionKey);
                        // 读事件
                    }else if(selectionKey.isReadable()){
                        handleRead(selectionKey);
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private static void handleConnectable(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        // 设置读写非阻塞
        socketChannel.configureBlocking(false);

        if(socketChannel.isConnectionPending()){
            System.out.println("与服务端建立连接完成");
            socketChannel.finishConnect();
        }
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("hello i am NIO client!".getBytes());
        buffer.flip();
        // 给服务端写数据
        socketChannel.write(buffer);
        // 维持当前连接不断开，注册读取事件
        socketChannel.register(selector,SelectionKey.OP_READ);
    }

    private static void handleRead(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();

        // 设置读写非阻塞
        socketChannel.configureBlocking(false);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 从服务端读数据
        socketChannel.read(buffer);
        System.out.println("收到服务端数据："+new String(buffer.array(),0,buffer.position()));
    }
}
