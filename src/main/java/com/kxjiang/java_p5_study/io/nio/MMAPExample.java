package com.kxjiang.java_p5_study.io.nio;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 基于内存0拷贝的方式实现文件复制
 *
 * @author kxjiang
 * @date 2022-03-30 23:45
 */
@SuppressWarnings("all")
public class MMAPExample {
    public static void main(String[] args) throws IOException {
        // windons界面操作大概20秒
        long start = System.currentTimeMillis();
        FileChannel inChannel = FileChannel.open(Paths.get("G:\\chromeDownload\\devecostudio-windows-tool-3.0.0.601.zip"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("G:\\chromeDownload\\devecostudio-windows-tool-3.0.0.601_cp.zip"),StandardOpenOption.READ,StandardOpenOption.WRITE, StandardOpenOption.CREATE);


        MappedByteBuffer inMappedByteBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY,0, inChannel.size());
        MappedByteBuffer outMappedByteBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE,0, inChannel.size());

        byte[] bytes = new byte[inMappedByteBuffer.limit()];
        inMappedByteBuffer.get(bytes);
        outMappedByteBuffer.put(bytes);
        inChannel.close();
        outChannel.close();
        System.out.println("mmap实现copy用时："+(System.currentTimeMillis() - start)+" ms");
    }
}
