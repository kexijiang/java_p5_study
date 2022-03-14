package com.kxjiang.java_p5_study.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author kxjiang
 * @date 2022-03-14 21:26
 */
public class FileExample {
    public static void main(String[] args) {
        try(InputStreamReader reader= new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(reader)){
            String path = bufferedReader.readLine();
            File file = new File(path);
            if(file.isDirectory() && file.exists()){
                // 遍历这个目录下的所有子目录
                fileList(file);
            }else{
                System.out.println("文件路径输入错误。");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void fileList(File filePath){
        File[] files = filePath.listFiles();
        if(files!=null){
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                } else {
                    // 如果是一个目录
                    fileList(file);
                }
            }
        }
    }
}
