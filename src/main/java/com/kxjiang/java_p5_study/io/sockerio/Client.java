package com.kxjiang.java_p5_study.io.sockerio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author kxjiang
 * @date 2022-03-22 21:44
 */
public class Client {
    public static void main(String[] args) {
        try {
            // 获取socket输出流
            Socket socket = new Socket("localhost",8080);
            OutputStream outputStream = socket.getOutputStream();
            // 写出数据
            outputStream.write("hello,world!\n".getBytes(StandardCharsets.UTF_8));

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("接受到服务端消息："+reader.readLine());

            reader.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
