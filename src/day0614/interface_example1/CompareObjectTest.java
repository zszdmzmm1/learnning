package day0614.interface_example1;

public class CompareObjectTest {
    public static void main(String[] args) {
        ComparableCircle c1 = new ComparableCircle(6.0);
        ComparableCircle c2 = new ComparableCircle(9.0);
        System.out.println(c1.compareTo(c2));
    }
}
