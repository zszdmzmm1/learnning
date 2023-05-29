package day0529;

public class Arithmetic {
    public static void main(String[] args) {
        int a = 12;
        int b = 5;

        int result0 = a / b;
        double result1 = a / b;
        double result2 = (double) a / b;
        double result3 = (double) (a / b);
        double result4 = a / b + 0.0;
        double result5 = a * 1.0 / b;

        System.out.println(result0);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);


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
