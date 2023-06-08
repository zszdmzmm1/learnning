package day0608.student;

public class Student {
    int number;
    int state;
    int score;

    public void addStudent(int order){
            number = order;
            state = (int) Math.round(Math.random() * 6 + 1);
            score = (int) (Math.random() * 101);
    }


    public static void sort(Student[] arrs) {
        Student temp;
        for (int i = 0; i < arrs.length - 1; i++) {
            for (int j = 0; j < arrs.length - i - 1; j++) {
                if (arrs[j].score > arrs[j + 1].score) {
                    temp = arrs[j];
                    arrs[j] = arrs[j + 1];

                    arrs[j + 1] = temp;
                }
            }
        }
    }


    @Override
    public String toString() {
        return "Student{" +
                "number=" + number +
                ", state=" + state +
                ", score=" + score +
                '}';
    }
}
