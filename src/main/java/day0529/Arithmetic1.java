package day0529;

/**
 * ++与--的两个特性
 */

public class Arithmetic1 {
    public static void main(String[] args) {

        //++与--在前时先执行++（--）再计算，在后时先计算再执行
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
        
        
        
        //j++, j--等代码在执行时可以保证i的数据类型不变
        byte j = 126;
        System.out.println("++j = " + ++j);
        System.out.println("++j = " + ++j);
    }
}

