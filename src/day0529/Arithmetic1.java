package day0529;

public class Arithmetic1 {
    public static void main(String[] args) {
        int i1 = 18;
        int i2 = 28;
        int i =  i1++;

        System.out.print("i = " + i ); //18
        System.out.println("i1 = " + i1); //19

        i = ++i1;
        System.out.print("i = " + i ); //20
        System.out.println("i1 = " + i); //20

        i = i2--;
        System.out.print("i = " + i ); //28
        System.out.println("i2 = " + i2); //27

        i = --i2;
        System.out.print("i = " + i ); //26
        System.out.println("i2 = " + i2); //26
    }
}

