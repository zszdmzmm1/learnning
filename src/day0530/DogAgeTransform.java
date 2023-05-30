package day0530;

import java.util.Scanner;

public class DogAgeTransform {
    public static void main(String[] args) {
        System.out.print("请输入狗的年龄：");
        Scanner sc = new Scanner(System.in);
        int dogAge = sc.nextInt();


        double age = 0.0;
        if (dogAge >= 0 && dogAge < 2) {
            age = dogAge * 10.5;
            System.out.println("age = " + age);
        } else if (dogAge >= 2) {
            age = 21 + 4 * (dogAge - 2);
            System.out.println("age = " + age);
        } else {
            System.out.println("输入错误");
        }
    }
}
