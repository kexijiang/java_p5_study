package com.kxjiang.java_p5_study.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author kxjiang
 * @date 2022-03-28 22:46
 */
public class NIOFileCopyExample {
    public static void main(String[] args) {
        try {
            long start = System.currentTimeMillis();
            FileInputStream fis = new FileInputStream("E:\\test.txt");
            FileOutputStream fos = new FileOutputStream("E:\\test-copy.txt");
            // NIO的api
            FileChannel fin = fis.getChannel();
            FileChannel fout = fos.getChannel();

            // 初始化一个缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (fin.read(buffer) != -1) {
                // 从读转化为写
                buffer.flip();
                // 从缓冲区写入到通道
                fout.write(buffer);
                // 清空缓冲区
                buffer.clear();
            }

            System.out.println("NIO复制文件用时：" + (System.currentTimeMillis() - start) + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
