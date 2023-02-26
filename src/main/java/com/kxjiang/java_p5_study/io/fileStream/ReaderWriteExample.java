package com.kxjiang.java_p5_study.io.fileStream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author kxjiang
 * @date 2022-03-17 22:03
 */
public class ReaderWriteExample {
    public static void main(String[] args) {
        try(FileReader reader = new FileReader("E:\\mic.txt");
            FileWriter writer = new FileWriter("E:\\mic-copy.txt")){
            int i = 0;
            char[] by = new char[1024];
            while((i=reader.read(by))!=-1){
                System.out.println(new String(by,0,i));
                writer.write(by,0,i);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
