package day0609;

public class Student {
    String name;
    int age;
    String school;
    String major;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(String name, int age, String school) {
        this(name, age);
        this.school = school;
    }

    public Student(String name, int age, String school, String major) {
        this(name, age, school);
        this.major = major;
    }

}
