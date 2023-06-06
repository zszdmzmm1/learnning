package day0606;

public class MathClassTexting {
    public static void main(String[] args) {
        //Math.absExact: 超出会报错，而不是给出一个错误值
        //System.out.println(Math.absExact(0x80000000));
        System.out.println(Math.abs(0x80000000));
        System.out.println(Math.absExact(0x7FFFFFFF));


        //----  ----- -------
        //Math.cbrt(double a) 立方根
        System.out.println(Math.cbrt(-0));



        //---- ---- ---- ---
        //Math.ceil(double a) 向上取双精度整数，返回double数据类型
        System.out.println(Math.ceil(-5.34));

        //Math.floor(double a) 向下取双精度整数，返回double数据类型
        System.out.println(Math.floor(-1.4));

        //Math.rint(double a) 取最近双精度整数，一样近则取偶数，返回double数据类型
        System.out.println(Math.rint(1.5));

        //Math.round(double a) 四舍五入, 返回long数据类型
        System.out.println(Math.round(2.5));


        //---- -- --- - -- -- ---
        //Math.row 乘方
        System.out.println(Math.pow(2,3));




    }
}
