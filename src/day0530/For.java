package day0530;

public class For {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello World!");
        }

        int num = 1;
        for (System.out.print("a"); num <= 3; System.out.print("c"), num++) {
            System.out.print("b");
        }

        for (int i = 0; i < 150; i++) {
            System.out.print(i + " ");
            if (i % 3 == 0){
                System.out.print("g3 ");
            }
            if (i % 5 == 0){
                System.out.print("g5 ");
            }
            if (i % 7 == 0){
                System.out.print("g7 ");
            }
            System.out.println();
        }
    }
}
