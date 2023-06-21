package day0614.interface_example1;

public class ComparableCircle extends Circle implements CompareObject {
    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        super(radius);
    }


    @Override
    public int compareTo(Object o) {
        if (this == o) {
            return 0;
        }
        if (o instanceof ComparableCircle) {
            ComparableCircle compareCircle = (ComparableCircle) o;
            return Double.compare(this.getRadius(), compareCircle.getRadius());
        } else {
            throw new RuntimeException("输入类型不匹配");
        }
    }
}
