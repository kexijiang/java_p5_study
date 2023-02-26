package com.kxjiang.java_p5_study.io.fileStream;

import java.io.*;

/**
 * @author kxjiang
 * @date 2022-03-17 21:15
 */
public class BufferedExample {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("E://test.txt"));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("E://txt.txt"));
        int len = 0;
        byte[] bys = new byte[1024];
        while ((len = bufferedInputStream.read(bys)) != -1) {
            System.out.println(new String(bys, 0, len));
            bufferedOutputStream.write(bys, 0, len);
            bufferedOutputStream.flush();
        }
    }
}
