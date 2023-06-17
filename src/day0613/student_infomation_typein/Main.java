package day0613.student_infomation_typein;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int condition;
        String name;
        int age;
        System.out.println("请录入学生的信息");
        List<Student> list = new ArrayList<>();
        do {
            System.out.println("1:继续录入，0：结束录入");
            condition = sc.nextInt();
            if(condition == 0){
                break;
            }else if(condition == 1){
                System.out.print("请输入学生姓名：");
                name = sc.next();
                System.out.print("请输入学生年龄：");
                age = sc.nextInt();
                list.add(new Student(name, age));
            }
        } while(true);
        for(Student s: list){
            System.out.println(s);
        }
    }
}
