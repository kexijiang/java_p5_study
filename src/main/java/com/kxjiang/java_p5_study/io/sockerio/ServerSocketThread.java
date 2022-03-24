package com.kxjiang.java_p5_study.io.sockerio;

import lombok.SneakyThrows;

import java.io.*;
import java.net.Socket;

/**
 * @author kxjiang
 * @date 2022-03-24 23:01
 */
public class ServerSocketThread implements Runnable{
    private final Socket socket;
    public ServerSocketThread(Socket socker) {
        this.socket = socker;
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println("客户端："+socket.getPort()+"已连接");
        // 从socket获取输入流 并使用缓冲流对普通流进行包装
        // 进行字节流转字符流
        BufferedReader reader = new BufferedReader(new InputStreamReader(new BufferedInputStream(socket.getInputStream())));
        System.out.println("收到客户端消息："+reader.readLine());
        Thread.sleep(10000);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(socket.getOutputStream())));
        writer.write("接受到你的消息！\n");
        writer.flush();
    }
}
