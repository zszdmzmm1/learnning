package day03;

public class DateType2 {
    public static void main(String[] args) {
        char ch1 = 'a';
        byte by1 = 4;
        short sh1 = 5, sh2 = 6;
        int in1 = 6, in2 = 98;
        long lo1 = 6L;
        float fl1 = 3.5F;
        double do1 = 4.5;


        //运算
        //byte,char,short -> int -> long -> float -> double
        //byte,char, short互相运算，转化为int
        int in3 = by1 + sh1 + ch1;
        //char ch2 = sh1 +sh2;
        float fl2 = in1 + in2;
        double do2 = fl1 + in1;
        //int in4 = fl1  + do1;
    }
}
