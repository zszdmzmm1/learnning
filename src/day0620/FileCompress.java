package day0620;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 压缩两级文件，zip格式。
 */

public class FileCompress {

    public static void main(String[] args) throws Exception {
        compressFileByZIP("C:\\Users\\86173\\Desktop\\毕业论文.docm");
    }

    private static String compressFileByZIP(String filePath) throws Exception {
        File file = new File(filePath);
        System.out.println(filePath + ".zip");
        String outputFIleName = filePath + ".zip";
        ArrayList<File> fileList = new ArrayList<>();
        if (file.isDirectory()) {
            fileList.addAll(Arrays.asList(file.listFiles()));
        } else {
            fileList.add(file);
        }
        FileInputStream fileInputStream = null;
        CheckedOutputStream checkedOutputStream = new CheckedOutputStream(new FileOutputStream(outputFIleName), new Adler32());
        ZipOutputStream zipOutputStream = new ZipOutputStream(checkedOutputStream, StandardCharsets.UTF_8);
        for (File f : fileList) {
            if (f.isDirectory()) {
                continue;
            }
            zipOutputStream.putNextEntry(new ZipEntry(f.getName()));
            fileInputStream = new FileInputStream(f);
            byte[] bytes = new byte[1024];
            while ((fileInputStream.read(bytes)) != -1) {
                zipOutputStream.write(bytes);
            }
        }
        fileInputStream.close();
        zipOutputStream.close();
        return outputFIleName;
    }
}
