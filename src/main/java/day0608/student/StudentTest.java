package day0608.student;


public class StudentTest {
    public static void main(String[] args) {
        Student[] st = new Student[20];

        for (int i = 0; i < 20; i++) {
            Student sts = new Student();
            sts.addStudent(i + 1);
            st[i] = sts;
        }


        Student.sort(st);
        for (int i = 0; i < 20; i++) {
            System.out.println(st[i]);
        }
    }
}
