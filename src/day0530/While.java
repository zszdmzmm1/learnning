package day0530;

public class While {
    public static void main(String[] args) {


        int i = 1, sum = 0, count = 0;
        while (i <= 100) {
            if (i % 2 == 0){
                count++;
                sum += i;
            }
            i++;
        }
        System.out.println("sum = " + sum);
        System.out.println("count = " + count);
    }
}
