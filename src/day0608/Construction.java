package day0608;

public class Construction {
    public static void main(String[] args) {
        Student student1 = Student.getInstance();
        Student student2 = Student.getInstance();
        System.out.println(student1);
        System.out.println(student2);

        System.out.println("----------------");
        Student s1 = Student.getInstances();
        Student s2 = Student.getInstances();
        Student s3 = Student.getInstances();
        Student s4 = Student.getInstances();
        System.out.println(s1);
        System.out.println(Student.students[0]);
        System.out.println(s2);
        System.out.println(Student.students[1]);
        System.out.println(s3);
        System.out.println(Student.students[2]);
        System.out.println(s4);
    }
}


class Student {
    String id;
    String name;
    int age;
    static Student student;
    static Student[] students = new Student[3];

    private Student() {

    }

    public static Student getInstance() {
        if (student == null) {
            student = new Student();
        }
        return student;
    }

    public static Student getInstances() {
        Student s = new Student();
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = new Student();
                s = students[i];
                break;
            }
        }
        return s;
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
