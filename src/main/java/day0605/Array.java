package day0605;

public class Array {
    public static void main(String[] args) {
        double[] numbers = {3.8, 8.6, 1.9, -3.4};
        double sum = 0.0;
        for (double number : numbers) {
            System.out.println(number);
            sum += number;
        }
        System.out.println("sum = " + sum);
    }
}
