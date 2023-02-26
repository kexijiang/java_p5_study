package com.kxjiang.java_p5_study.io.fileStream;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author kxjiang
 * @date 2022-03-21 21:40
 */
public class MMapExample {
    public static void main(String[] args) throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("G:\\chromeDownload\\windows_11_professional_x64_2021.iso"),
            StandardOpenOption.READ);
        FileChannel outChannel =
            FileChannel.open(Paths.get("G:\\chromeDownload\\windows_11_professional_x64_2021-0copy.iso"),
                StandardOpenOption.READ, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        long start = System.currentTimeMillis();
        MappedByteBuffer inMappedByteBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMappedByteBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());
        byte[] bytes = new byte[inMappedByteBuffer.limit()];

        inMappedByteBuffer.get(bytes);
        outMappedByteBuffer.put(bytes);
        inChannel.close();
        outChannel.close();

        System.out.println("拷贝用时：" + (System.currentTimeMillis() - start) + " ms");
    }
}
