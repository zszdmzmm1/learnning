package day03;

public class DateType3 {
    public static void main(String[] args) {
        double dou1 = 19.9;
        int int1 = (int)dou1;

        //损耗
        long long1 = 129;
        //无损
        short sh1 = (short) long1;
        //溢出
        byte by1 = (byte) long1;


        System.out.println(int1);
        System.out.println(sh1);
        System.out.println(by1);
    }
}
