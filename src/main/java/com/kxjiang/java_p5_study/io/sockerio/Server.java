package com.kxjiang.java_p5_study.io.sockerio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author kxjiang
 * @date 2022-03-22 21:41
 */
@SuppressWarnings("all")
public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            // 1.bio
            /*while(true){
                // 绑定一个端口，监听该端口
                serverSocket = new ServerSocket(8080);
                // 等待客户端的连接  阻塞
                Socket socket = serverSocket.accept();
                System.out.println("客户端："+socket.getPort()+"已连接");
                // 从socket获取输入流 并使用缓冲流对普通流进行包装
                // 进行字节流转字符流
                BufferedReader reader = new BufferedReader(new InputStreamReader(new BufferedInputStream(socket.getInputStream())));
                System.out.println("收到客户端消息："+reader.readLine());
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(socket.getOutputStream())));
                writer.write("接受到你的消息！\n");
                writer.flush();
            }*/
            // 2.第一步优化，将每个socket都丢给一个线程
            ExecutorService executorService = Executors.newFixedThreadPool(10);
            // 将每一个socket连接都开启一个线程
            // 等待客户端的连接
            serverSocket = new ServerSocket(8080);
            while (true) {
                Socket socket = serverSocket.accept();
                executorService.execute(new ServerSocketThread(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
