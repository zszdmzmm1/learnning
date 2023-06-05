package day0605;

import java.util.Scanner;

/**
 * 学生考试等级划分
 *
 * 问题描述
 * 从键盘读入学生成绩，找出最高分，并输出学生成绩等级。
 * 	 成绩>=最高分-10    等级为’A’
 * 	 成绩>=最高分-20    等级为’B’
 * 	 成绩>=最高分-30    等级为’C’
 * 	 其余              等级为’D’
 *
 * 预期结果
 *   从键盘输入学生总人数
 *   如何一个个输入学生成绩
 *   最后输出最高分和每个学生成绩等级
 *     - 最高分是：**
 *     - 第**个学生的分数是**，对应等级为[A|B|C|D]
 *
 */

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
