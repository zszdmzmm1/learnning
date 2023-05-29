package day0529;

public class Text {
    public static void main(String[] args) {
        System.out.println("a" + "\t" + "\t" + "b" + "\t" + "\t" + "a&b" + "\t" + "\t" + "a&&b" + "\t" + "a|b" + "\t" + "\t" + "a||b" + "\t" + "!a" + "\t" + "\t" + "a^b");
        System.out.println("--------------------------------------------------------------");
        boolean a = true;
        boolean b = true;
        System.out.println(a + "\t" + b + "\t" + (a&b) + "\t" + (a&&b) + "\t" + (a|b) + "\t" + (a||b) + "\t" + (!a) + "\t" + (a^b));

        b = false;
        System.out.println(a + "\t" + b + "\t" + (a&b) + "\t" + (a&&b) + "\t" + (a|b) + "\t" + (a||b) + "\t" + (!a) + "\t" + (a^b));

        a = false;
        b = true;
        System.out.println(a + "\t" + b + "\t" + (a&b) + "\t" + (a&&b) + "\t" + (a|b) + "\t" + (a||b) + "\t" + (!a) + "\t" + (a^b));

        b = false;
        System.out.println(a + "\t" + b + "\t" + (a&b) + "\t" + (a&&b) + "\t" + (a|b) + "\t" + (a||b) + "\t" + (!a) + "\t" + (a^b));
    }
}
