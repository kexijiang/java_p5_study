package com.kxjiang.java_p5_study.io.fileStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author kxjiang
 * @date 2022-03-14 21:36
 */
public class ByteInputStreamExample {
    // 1.input 从磁盘读取数据到内存
    // 2.output 从内存的数据写入到磁盘
    public static void main(String[] args) throws IOException {
        File file = new File("E:\\logo.png");
        FileInputStream inputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\logo-copy.png");
        int len = 0;
        // 缓冲区 1024字节，1kb
        byte[] buffer = new byte[1024];

        while ((len = inputStream.read(buffer)) != -1) {
            fileOutputStream.write(buffer, 0, len);// 把inputStream的输入字节写出到指定的目录下
        }
        inputStream.close();
        fileOutputStream.close();
    }
}
