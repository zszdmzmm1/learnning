package day0607.state;

public class Student {
    int ID;
    String name;
    int age;
    Dog[] dogs;


    public void infoShow() {
        System.out.print("学生(" + ID + "学号)的信息：学号=" + ID + "、姓名=" + name + "、年龄=" + age + "、狗的信息：");
        printDog();
    }

    public void printDog() {
        for (int i = 0; i < dogs.length; i++){
            dogs[i].showDog();
        }
        System.out.println();
    }


}
