package day0614;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 *给定一个日期，返回该日期的周数
 */

public class DateCauculate {
    public static void main(String[] args) throws ParseException {
        //方法1：
        Calendar canlendar = Calendar.getInstance();
        canlendar.set(1998, 5, 5);//月份从0开始计算
        Date aDate = canlendar.getTime();

        //方法二
        SimpleDateFormat oringinDate = new SimpleDateFormat("yyyy-MM-dd");
        Date anotherDate = oringinDate.parse("1998-06-05");


        //-----------------------------------------------------------------------
        SimpleDateFormat aWeek = new SimpleDateFormat("ww");
        String sWeek = aWeek.format(aDate);
        String sWeek1 = aWeek.format(anotherDate);
        System.out.println(sWeek);
        System.out.println(sWeek1);
    }
}
