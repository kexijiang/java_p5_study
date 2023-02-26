package com.kxjiang.java_p5_study.io.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author kxjiang
 * @date 2022-03-28 23:03
 */
public class NIOReadExample {
    public static void main(String[] args) {
        try (FileInputStream inputStream = new FileInputStream("E:\\test.txt")) {
            FileChannel fileChannel = inputStream.getChannel();
            // 一次读取字节数
            ByteBuffer byteBuffer = ByteBuffer.allocate(10);
            // 如果rs = -1 代表文件读取结束
            int rs = fileChannel.read(byteBuffer);

            System.out.println(new String(byteBuffer.array()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
