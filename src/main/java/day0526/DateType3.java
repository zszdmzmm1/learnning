package day0526;

/**
 * 数据类型的强制转换与转换损耗
 */

public class DateType3 {
    public static void main(String[] args) {
        double dou1 = 19.9;
        //取整损耗
        int int1 = (int)dou1;


        long long1 = 128L;
        //无损
        short sh1 = (short)long1;
        //溢出
        byte by1 = (byte)long1;

        /* 溢出原理：
            0 00000000 ... 1111111(127) + 0 0000000 ... 00000001(1) = 0 0000000 ... 100000000(128) 其中首位为符号位
            强制转化为byte，截住后8位，1 0000000。同理，第一位为符号位，即负数。
            后7位求原码，取反加一：0000000 -> 1111111 -> 10000000(128)
            故结果为-128。
        */

        System.out.println(int1);
        System.out.println(sh1);
        System.out.println(by1);
    }
}
