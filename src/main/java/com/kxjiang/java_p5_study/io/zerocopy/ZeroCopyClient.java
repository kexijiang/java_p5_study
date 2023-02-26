package com.kxjiang.java_p5_study.io.zerocopy;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * @author kxjiang
 * @date 2022-04-01 21:50
 */
@SuppressWarnings("all")
public class ZeroCopyClient {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress(8080));
        FileChannel fileChannel =
            new FileInputStream("G:\\chromeDownload\\devecostudio-windows-tool-3.0.0.601.zip").getChannel();
        long size = fileChannel.size();
        int position = 0;
        while (size > 0) {
            // 返回传输字节数
            long tf = fileChannel.transferTo(position, size, socketChannel);
            // 读取文件位置，每次都递增，从已发送完成的位置继续读取发送
            position += tf;
            // 总大小每次都递减，因为内核缓冲区大小有限，0拷贝会每次只发送内核缓冲区大小的数据
            size -= tf;
        }

        socketChannel.close();
        fileChannel.close();

        System.out.println("传输文件完成，共传输字节数：" + position + " 耗时：" + (System.currentTimeMillis() - start) + " ms");
    }
}
