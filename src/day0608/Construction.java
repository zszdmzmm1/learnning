package day0608;

public class Construction {
    public static void main(String[] args) {
        Student student1 = Student.getInstance();
        Student student2 = Student.getInstance();
        System.out.println(student1);
        System.out.println(student2);
/*        Student s1 = Student.getInstances();
        Student s2 = Student.getInstances();
        Student s3 = Student.getInstances();
        Student s4 = Student.getInstances();
        System.out.println(s1);
        System.out.println(Student.students[0]);
        System.out.println(s2);
        System.out.println(Student.students[1]);
        System.out.println(s3);
        System.out.println(Student.students[2]);
        System.out.println(s4);*/
    }
}


class Student{
    String id;
    String name;
    int age;
    static Student student;
    //static Student[] students;

    private Student(){

    }

    public static Student getInstance(){
        if(student == null){
           student = new Student();
       }
       return student;
    }


/*    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }*/
}
