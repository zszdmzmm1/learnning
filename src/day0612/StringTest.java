package day0612;

public class StringTest {
    public static void main(String[] args) {
        /*String lowCase = new String("jdk");
        String upCase = lowCase.toUpperCase();
        System.out.println(upCase);
        System.out.println(upCase.substring(1, 3));*/

        String target = "gahsdgjahiuhiwhgaishdivahzzz";
        char[] ch = target.toCharArray();
        for (int i = 97; i < 123; i++) {
            int num = 0;
            for (int j = 0; j < ch.length; j++) {
                if (ch[j] == (char) i) {
                    num++;
                }
            }
            if (num != 0) {
                System.out.println((char) i + " = " + num);
            }
        }

    }
}
