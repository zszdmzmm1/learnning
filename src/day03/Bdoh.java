package day03;
/**
 *  - 二进制 binary, 0b/0B 0-1
 *  - 十进制 decimal， 0-9
 *  - 八进制 octal， 0， 0-7
 *  - 十六进制 hex， 0x， 0-9-A-F
 */
public class Bdoh {
    public static void main(String[] args) {
        int binaryNum = 0b110;
        int decimalNum = 110;
        int octalNum = 0127;
        int hexNum = 0x110A;

        System.out.println("binaryNum = " + binaryNum);
        System.out.println("decimalNum = " + decimalNum);
        System.out.println("octalNum = " + octalNum);
        System.out.println("hexNum = " + hexNum);
    }
}
