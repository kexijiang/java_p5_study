package com.kxjiang.java_p5_study.io.sockerio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author kxjiang
 * @date 2022-03-22 21:41
 */
public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            // 绑定一个端口，监听该端口
            serverSocket = new ServerSocket(8080);
            // 等待客户端的连接  阻塞
            Socket socket = serverSocket.accept();
            System.out.println("客户端："+socket.getInetAddress()+"已连接");
            // 从socket获取输入流 并使用缓冲流对普通流进行包装
            // 进行字节流转字符流
            BufferedReader reader = new BufferedReader(new InputStreamReader(new BufferedInputStream(socket.getInputStream())));

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(socket.getOutputStream())));

            System.out.println("收到客户端消息："+reader.readLine());

            writer.write(Arrays.toString("接受到你的消息！\n".getBytes(StandardCharsets.UTF_8)));
            reader.close();
            writer.close();
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
