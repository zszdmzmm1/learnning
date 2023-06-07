package day0607.state;

public class StudentTest {
    public static void main(String[] args) {
        Student st1 = new Student();
        st1.ID = 191201;
        st1.age = 19;
        st1.name = "LSH";
        Dog dog1 = new Dog();
        dog1.ID = 1;
        dog1.color = "black";
        dog1.name = "ff";
        Dog dog2 = new Dog();
        dog2.ID = 2;
        dog2.color = "white";
        dog2.name = "gg";
        Dog[] ds1 = new Dog[]{dog1, dog2};
        st1.dogs = new Dog[]{dog1};
        //st1.dogs = ds1;
        //System.out.println("学生(" + st1.ID + "学号)的信息：学号=" + st1.ID + "、姓名=" + st1.name + "、年龄=" + st1.age);
        st1.infoShow();


    }
}
