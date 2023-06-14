package day0614;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//小明出生于2012年，爷爷出生于61年前，爸爸比爷爷小23岁，出生日期是11月6日，求爸爸的出生日期。
public class Test {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2012 - 61 + 23, Calendar.NOVEMBER, 6);
        //calendar.set(2012 - 61 + 23, 11  - 1, 6);//月份从0开始计算
        Date birthday = calendar.getTime();
        System.out.println(birthday);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(birthday));
    }
}
