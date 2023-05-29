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

    }
}
