package com.kxjiang.java_p5_study.io.fileStream;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 字节流转字符流，可以做不同编码格式的转换
 *
 * @author kxjiang
 * @date 2022-03-17 22:10
 */
public class ConvertExample {
    public static void main(String[] args) {
        try(InputStream inputStream = new FileInputStream("E:\\mic.txt")){
            InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(reader);
            System.out.println(bufferedReader.readLine());
//            int i = 0;
//            char[] by = new char[1024];
//            while ((i = bufferedReader.read(by))!=-1){
//                System.out.println(new String(by,0,i));
//            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
