package day0529;

/**
 * 位运算
 */
public class Bit {
    public static void main(String[] args) {
        byte num = 1;
        System.out.println("num = " + (num << 14));

        int a = 12;
        int b = 5;

        System.out.println(a & b);
        System.out.println(a ^ b);


        System.out.println("a = " + (a ^ b ^ b));
        System.out.println("b = " + (a ^ b ^ a));


    }
}
