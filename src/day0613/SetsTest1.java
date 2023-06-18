package day0613;
/**
 * 从1-50输出10个不同的随机数
 */

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SetsTest1 {
    public static void main(String[] args) {
        Random rd = new Random();
        Set set = new HashSet();
        while(set.size() != 10){
            set.add(rd.nextInt(50) + 1);
        }
        System.out.println(set);
    }
}
