package day0605;

import java.util.Scanner;

public class ScoreGrade {
    public static void main(String[] args) {
        System.out.print("请输入学生人数：");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] score = new int[num];
        for (int i = 0; i < num; i++) {
            System.out.print("请输入第" + (i + 1) + "个学生的成绩：");
            score[i] = sc.nextInt();
        }
        int max = score[0];
        for (int i = 0; i < num; i++) {
            if(score[i] > max){
                max = score[i];
            }
        }
        System.out.println("最高分是： " + max);
        char grade;
        for (int i = 0; i < num; i++) {
            if (score[i] >= max - 10){
                grade = 'A';
            } else if (score[i] >= max -20) {
                grade = 'B';
            } else if (score[i] >= max - 30) {
                grade = 'C';
            } else {
                grade = 'D';
            }
            System.out.println("第" + (i + 1) + "个学生的分数是：" + score[i] + ",对应的等级是" + grade);
        }
    }
}
