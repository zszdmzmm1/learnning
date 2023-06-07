package day0607.state;

public class StudentTest {
    public static void main(String[] args) {
        Student st1 = new Student();
        Student st2 = new Student();
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        Dog dog3 = new Dog();


        dog1.ID = 1;
        dog1.color = "black";
        dog1.name = "ff";

        dog2.ID = 2;
        dog2.color = "white";
        dog2.name = "gg";

        dog3.ID = 3;
        dog3.color = "orange";
        dog3.name = "ss";

        Dog[] ds1 = new Dog[]{dog1};
        Dog[] ds2 = new Dog[]{dog2, dog3};

        st1.ID = 191201;
        st1.age = 19;
        st1.name = "LSH";
        st1.dogs = new Dog[]{dog1};
        //st1.dogs = ds1;

        st2.name = "ZPY";
        st2.age = 19;
        st2.ID = 191202;
        st2.dogs = new Dog[]{dog2, dog3};
        //st2.dogs = ds2;

        //System.out.println("学生(" + st1.ID + "学号)的信息：学号=" + st1.ID + "、姓名=" + st1.name + "、年龄=" + st1.age);
        st1.infoShow();
        st1.printDog();
        st2.infoShow();
        st2.printDog();

    }
}
