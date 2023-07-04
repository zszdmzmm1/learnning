package day0619;


import java.io.File;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) throws IOException {
        File file = new File("/a.doc.2/Java/secret.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        System.out.println(file.length());
        int index = file.getName().indexOf('.');
        System.out.println(file.getName().substring(index + 1));
        System.out.println(file.getName().substring(0, index));
    }
}
