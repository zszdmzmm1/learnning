package day0612;

import java.util.Locale;
import java.util.Objects;

public class StringMethod {
    public static void main(String[] args) {
        /*StringBuffer sMessage = new StringBuffer("jka");
        StringBuffer sFinalMessage =  sMessage.append("_").append("yeah");
        System.out.println("sFinalMessage = " + sFinalMessage);
        String sFinal = sFinalMessage.toString();
        System.out.println("sResult = " + sFinal);

        String s = new String();
        System.out.println("s = " + s);*/


        String forTest = new String("There is a girl in my sight.");

        /*将String修改为char数组。*/
        System.out.println(forTest.toCharArray());
        System.out.println(forTest.toCharArray()[0]);


        /*比较两个String类型是否相同，输出类型是boolean值，若用 == 来比较，比较的是地址*/
        forTest.equals("jisjfi");
        //也可写作：
        Objects.equals("forTest", "jisjfi");//需要导入 import java.util.Objects;


        /*变为大写，同理，toLowerCase*/
        System.out.println(forTest.toUpperCase(Locale.ROOT));
        System.out.println(forTest.toLowerCase(Locale.ROOT));

        /*输入index，输出对应位置的char值 */
        System.out.println(forTest.charAt(3));

        /*同上，但输出unicode值 */
        System.out.println(forTest.codePointAt(4));


        /**/
        System.out.println(forTest.codePointCount(0, 10));

        /*对象与参数String在字典序的相对位置，在前为负数，相等为0，在后为正数*/
        System.out.println(forTest.compareTo("There is a girl in my sight."));
        System.out.println(forTest.compareTo("Z"));
        System.out.println(forTest.compareTo("A"));


        /*链接*/
        System.out.println(forTest.concat("!!!!!"));

        /*是否包含，大小写敏感*/
        System.out.println(forTest.contains("there"));
        System.out.println(forTest.contains("There"));

        /*forTest.contentEquals(StringBuffer sb);*/


        /*插入，背不下来，有用再查*/
        char[] ch = {'s', 'f'};
        forTest.getChars(2, 3, ch, 0);
        System.out.println(ch[0]);

        /*返回第一次出现的索引，无则返回-1，同理还有lastIndexOf*/
        System.out.println(forTest.indexOf('e'));
        System.out.println(forTest.indexOf('-'));
        System.out.println(forTest.lastIndexOf('e'));
        System.out.println(forTest.lastIndexOf('-'));

        /*不解释*/
        forTest.length();
        System.out.println(forTest.repeat(3));

        /*替换*/
        System.out.println(forTest.replaceFirst("is", "are"));
        System.out.println(forTest.replaceAll("e", "a"));


        /*根据参数分割字符串*/
        String[] splitResults = forTest.split(" ");
        for (String splitResult : splitResults) {
            System.out.println(splitResult);
        }


        /*消除首尾全角与半角空格*/
        String temp = "   f d f    ";
        System.out.print(temp.strip());
        System.out.println("nn");


        /*将转义字符实现出来*/
        String temp1 = "\ndf\t";
        System.out.println(temp1.translateEscapes());


        /*消除半角空格*/
        System.out.print(temp.trim());
        System.out.println("nn");


        /*截取任意段*/
        System.out.println(forTest.substring(4, 9));


    }

}
