package day0529;

import java.util.Scanner;

/**
 *一个简单取余应用的例子
 */

public class Arithmetic2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int hundreds = num / 100;
        int tens = num / 10 % 10;
        int units = num % 10;

        System.out.println("百位数:" + hundreds);
        System.out.println("十位数:" + tens);
        System.out.println("个位数:" + units);
    }
}
