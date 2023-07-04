package day0529;

/**
 * 除法与取余的用法与细节
 */

public class Arithmetic {
    public static void main(String[] args) {
        int a = 12;
        int b = 5;

        //右侧以int计算，损耗后装进int变量里
        int result0 = a / b;
        System.out.println("result0 = " + result0);


        //右侧以int计算，损耗后装进double变量里
        double result1 = a / b;
        System.out.println("result1 = " + result1);


        //右侧强制转换成double计算，装进double变量里
        double result2 = (double) a / b;
        System.out.println("result2 = " + result2);


        //右侧以int计算，强制转换成double后装进double变量里
        double result3 = (double) (a / b);
        System.out.println("result3 = " + result3);


        //右侧以int计算，损耗后再与double计算，装进double变量里
        double result4 = a / b + 0.0;
        System.out.println("result4 = " + result4);


        //转换为double计算，装进double变量里
        double result5 = a * 1.0 / b;
        System.out.println("result5 = " + result5);


        // ---- ---- ----

        int c1 = 12;
        int c2 = -12;
        int d1 = 5;
        int d2 = -5;


        //以下例子表明，取余的正负只与被除数有关。
        int r1 = c1 % d1;
        System.out.println("r1 = " + r1);

        int r2 = c2 % d1;
        System.out.println("r2 = " + r2);

        int r3 = c1 % d1;
        System.out.println("r3 = " + r3);

        int r4 = c2 % d2;
        System.out.println("r4 = " + r4);

    }
}
