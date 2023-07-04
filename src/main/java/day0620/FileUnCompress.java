package day0620;

import java.io.*;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * 解压缩，只能解两级压缩的.zip格式文件。
 */
public class FileUnCompress {
    public static void main(String[] args) throws IOException {
        extractZip("C:\\Users\\86173\\Desktop\\答案.zip");
    }

    public static String extractZip(String filePath) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        CheckedInputStream checkedInputStream = new CheckedInputStream(fileInputStream, new Adler32());
        ZipInputStream zipInputStream = new ZipInputStream(checkedInputStream);
        FileOutputStream fileOutputStream;
        File savePath = new File(filePath.replace(".zip", ""));
        if (!savePath.exists()) {
            savePath.mkdir();
        }
        ZipEntry zipEntry = null;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(zipInputStream);
        while ((zipEntry = zipInputStream.getNextEntry()) != null) {
            fileOutputStream = new FileOutputStream( filePath.replace(".zip", "") + File.separator + zipEntry.getName());
            byte[] bytes = new byte[1024];
            while (bufferedInputStream.read(bytes) != -1) {
                fileOutputStream.write(bytes);
            }
            fileOutputStream.close();

        }
        zipInputStream.close();
        fileInputStream.close();
        return null;
    }
}
