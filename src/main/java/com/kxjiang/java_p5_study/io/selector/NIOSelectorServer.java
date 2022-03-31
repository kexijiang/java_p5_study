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
 * @date 2022-03-31 19:41
 */
@SuppressWarnings("all")
public class NIOSelectorServer {
    private static Selector selector;
    public static void main(String[] args) throws IOException {
        selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 设置连接为非阻塞
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        try{
            while(true){
                // 此处会阻塞,如果有连接进来就会返回，不阻塞
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()){
                    SelectionKey selectionKey = iterator.next();
                    iterator.remove();
                    // 连接事件
                    if(selectionKey.isAcceptable()){
                        handleAcceptable(selectionKey);
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
    private static void handleAcceptable(SelectionKey key) throws IOException {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
        SocketChannel socketChannel = serverSocketChannel.accept();
        // 设置读写非阻塞
        socketChannel.configureBlocking(false);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("hello i am NIO server!".getBytes());
        buffer.flip();
        // 给客户端写数据
        socketChannel.write(buffer);
        // 维持当前连接不断开，注册读取事件
        socketChannel.register(selector,SelectionKey.OP_READ);
    }

    private static void handleRead(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();

        // 设置读写非阻塞
        socketChannel.configureBlocking(false);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 从客户端读数据
        socketChannel.read(buffer);
        System.out.println("收到客户端数据："+new String(buffer.array(),0,buffer.position()));
    }
}
