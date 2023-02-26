package com.kxjiang.java_p5_study.io.sockerio;

import java.io.*;
import java.net.Socket;

/**
 * @author kxjiang
 * @date 2022-03-22 21:44
 */
public class Client1 {
    public static void main(String[] args) {
        try {
            // 获取socket输出流
            Socket socket = new Socket("localhost", 8080);
            OutputStream outputStream = socket.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            // 写出数据
            writer.write("hello,world-1!\n");
            writer.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverStr = reader.readLine();
            System.out.println("接受到服务端消息：" + serverStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
