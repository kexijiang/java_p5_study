package com.kxjiang.java_p5_study.io;

import java.io.*;

/**
 * @author kxjiang
 * @date 2022-03-17 21:22
 */
public class BufferCopyExample {
    private static final File fileSource = new File("G:\\chromeDownload\\1福利素材-百款免费可商用字体（密）.zip");
    private static final File fileTarget = new File("G:\\chromeDownload\\1福利素材-百款免费可商用字体（密）-copy.zip");

    public void copyWithNormal() throws IOException {
        FileInputStream inputStream = new FileInputStream(fileSource);
        FileOutputStream outputStream = new FileOutputStream(fileTarget);
        int len = 0;
        byte[] bytes = new byte[8096];
        while ((len = inputStream.read(bytes))!=-1){
            outputStream.write(bytes,0,len);
            outputStream.flush();
        }
    }
    public void copyWithBuffered() throws IOException {
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fileSource));
        FileOutputStream outputStream = new FileOutputStream(fileTarget);
        BufferedOutputStream out = new BufferedOutputStream(outputStream);
        int len = 0;
        byte[] bys = new byte[1024];
        while ((len = inputStream.read(bys))!=-1){
            out.write(bys);
        }
    }

    public static void main(String[] args) {
        BufferCopyExample bufferCopyExample = new BufferCopyExample();
        long start = System.currentTimeMillis();
        try {
            bufferCopyExample.copyWithNormal();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("普通copy耗时："+(System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        try {
            bufferCopyExample.copyWithBuffered();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("缓冲流耗时："+(System.currentTimeMillis() - start));
    }
}
