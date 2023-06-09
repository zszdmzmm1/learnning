package day0609;

public class StackOverflow {
    public static void main(String[] args) {
        error.method();
    }
}
class error {
    public static void method(){
        System.out.println("777");
        method();
    }
}