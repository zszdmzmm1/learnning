package day03;

/**
 * String（字符串）的介绍与用法
 */
public class StringBasic {
    public static void main(String[] args) {
        byte s1  = 2;
        short s2 = 3;
        char s3 = 'j';
        int s4 = 3434;
        long s5 = 24324L;
        float s6 = 2.3434F;
        double s7 = 3.5353534;
        String s = "zszdmzmm";

        //字符串与基本数据类型相加，基本数据类型转化成字符串
        System.out.println(s1 + s);
        System.out.println(s2 + s);
        System.out.println(s3 + s);
        System.out.println(s4 + s);
        System.out.println(s5 + s);
        System.out.println(s6 + s);
        System.out.println(s7 + s);
    }
}
