package com.kxjiang.java_p5_study.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author kxjiang
 * @date 2022-03-14 21:08
 */
@SuppressWarnings("all")
public class FileInputStreamExample {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
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
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
