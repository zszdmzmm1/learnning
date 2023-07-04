package day0526;

/**
 * 不同的数据类型相互计算
 */

public class DateType2 {
    public static void main(String[] args) {
        //左边的变量”容器“接受了右边的数值，但并未改变性质。整数默认为int类型，小数默认是double类型
        char ch1 = 'a';
        byte by1 = 4;
        short sh1 = 5, sh2 = 6;
        int in1 = 6, in2 = 98;
        long lo1 = 6L;   //不加L，则默认将数以int形式存在long类型的变量中，实际造成超出int范围的大数据无法存储

        float fl1 = 3.5F; //不加F，则是以double形式将数存入float类型变量，以小存大，报错
        double do1 = 4.5;


        //运算
        /*  规则：
            1.byte, char, short -> int -> long -> float -> double 左边较小的“容器”计算可以被右边较大的“容器“接收，反之则不行。
            2.byte, char, short 互相运算，默认转化为int*/
        int in3 = by1 + sh1 + ch1;
        int in4 = in1 + in2;
        //char ch2 = sh1 +sh2; 违反2
        //short sh3 = by1 + ch1; 违反2
        float fl2 = in1 + in2;
        double do2 = fl1 + in1;
        //int in4 = fl1  + do1; 违反1
    }
}
