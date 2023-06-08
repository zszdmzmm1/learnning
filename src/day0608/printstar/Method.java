package day0608.printstar;

public class Method {
    public static void method1(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }


    public static int method2(){
        int num = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print("* ");
                num++;
            }
            System.out.println();
        }
        return num;
    }


    public static int method3(int m, int n){
        int num = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("* ");
                num++;
            }
            System.out.println();
        }
        return num;
    }


}
