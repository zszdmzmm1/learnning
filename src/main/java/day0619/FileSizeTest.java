package day0619;

import java.io.File;

public class FileSizeTest {
    public static void main(String[] args) {
        Method method = new Method();
        File file = new File("src");
        method.size(file);
    }
}

class Method {
    private long size;


    public void size(File file) {
        if (file.isDirectory()) {
            File[] fileList = file.listFiles();
            for (File f : fileList) {
                size(f);
            }
        } else {
            size += file.length();
        }
        System.out.println("大小 = " + this.size);
    }
}
