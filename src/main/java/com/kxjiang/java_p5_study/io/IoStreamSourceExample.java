package com.kxjiang.java_p5_study.io;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author kxjiang
 * @date 2022-03-14 21:17
 */
public class IoStreamSourceExample {
    public static void main(String[] args) throws IOException {
        // 磁盘io
        try {
            FileInputStream fileInputStream = null;
            fileInputStream = new FileInputStream("E:\\test.txt");
            int i = 0;
//            i = fileInputStream.read(); // 每次读取一个字节
//            System.out.println((char) i); //ASCII码
            // 文件结束的条件是字节为-1
            while((i=fileInputStream.read())!=-1){
                System.out.print((char) i);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        // 内存io
        String str = "hello world.";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
        int i = 0;
//            i = fileInputStream.read(); // 每次读取一个字节
//            System.out.println((char) i); //ASCII码
        // 文件结束的条件是字节为-1
        while((i=byteArrayInputStream.read())!=-1){
            System.out.print((char) i);
        }
        // 键盘io
        InputStream inputStream = System.in;
        int jpi = 0;
        while((jpi=inputStream.read())!=-1){
            System.out.print((char) jpi);
        }
        // 网络IO
        Socket socket = null;
        socket.getInputStream();
        socket.getOutputStream();
    }
}
