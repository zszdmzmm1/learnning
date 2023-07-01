package day0630;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args) {
        /**
         * 匹配
         * 3-4位区号 - 7-8位电话号码
         */
        String sRegex = "\\d{3,4}-\\d{7,8}";
        Scanner sc = new Scanner(System.in);
        String phone = sc.next();
        System.out.println(phone.matches(sRegex));


        Pattern pattern = Pattern.compile("([0-2]{1}[0-9]{1}):([0-6]{1}[0-9]{1}):([0-6]{1}[0-9]{1})");
        //Pattern pattern = Pattern.compile("(\\d\\d):(\\d\\d):(\\d\\d)");
        Matcher matcher =pattern.matcher("23:45:34");
        if(matcher.matches()){
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
        }else{
            System.out.println("jjjj");

        }
    }
}
