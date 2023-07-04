package day0530;

import java.util.Random;
import java.util.Scanner;

/**
 * 1.系统随机给出一个玩家看不到的1-100的随机整数
 * 2.玩家有10次猜数机会，答对则玩家胜利，结束程序，每次答错，系统会给出太大了或太小了的结果，次数用完，玩家失败。
 */

public class NumberGuessing {
    public static void main(String[] args) {
        Random ra = new Random();
        int r = ra.nextInt(101);

        Scanner sc = new Scanner(System.in);

        for (int count = 10; count > 0; count--) {
            System.out.print("请输入你猜的数字:");
            int guessNum = sc.nextInt();
            if (guessNum == r) {
                System.out.println("恭喜你，答对了");
                break;
            } else if ((count - 1) == 0) {
                System.out.println("正确答案是:" + r);
                System.out.println("你输了，请重新再试！");
            } else if (guessNum < r) {
                System.out.println("太小了，你还有" + (count - 1) + "次机会！");
            } else if (guessNum > r) {
                System.out.println("太大了，你还有" + (count - 1) + "次机会！");
            }
        }
    }
}
