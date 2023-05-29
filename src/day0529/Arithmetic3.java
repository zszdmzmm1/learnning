package day0529;

/**
 * +=, -=, /=, *=
 */

public class Arithmetic3 {
    public static void main(String[] args) {
        //与++ --相同，这些运算可以保留原本的数据类型

        //1.
        short s = 3;
        s += 2;
        System.out.println("s = " + s);

        //2.
        int i = 1;
        i *= 0.1;
        System.out.println(i);
        i++;
        System.out.println(i);

        //3.
        int m = 2;
        int n = 3;
        n *= m++;
        System.out.println(n);
        System.out.println(m);
    }
}
