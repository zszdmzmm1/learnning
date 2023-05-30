package day0530;

public class Table99 {
    public static void main(String[] args) {
        for (int i = 1, j = 1; i < 10; i++) {
            System.out.print("* ");
            for (j = 1; j <= i; j++){
                System.out.print(i + " * " + j + " = " + j * i + "  ");
            }
            System.out.println();
        }
    }
}
