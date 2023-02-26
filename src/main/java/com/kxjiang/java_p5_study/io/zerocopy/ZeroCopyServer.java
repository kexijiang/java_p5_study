package com.kxjiang.java_p5_study.io.zerocopy;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author kxjiang
 * @date 2022-04-01 21:46
 */
@SuppressWarnings("all")
public class ZeroCopyServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));
        FileChannel fileChannel = new FileOutputStream("G:/文件.zip").getChannel();
        try {
            SocketChannel socketChannel = serverSocketChannel.accept();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int r = 0;
            while (r != -1) {
                r = socketChannel.read(buffer);
                buffer.flip();
                fileChannel.write(buffer);
                buffer.clear();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            serverSocketChannel.close();
            fileChannel.close();
        }
    }
}
