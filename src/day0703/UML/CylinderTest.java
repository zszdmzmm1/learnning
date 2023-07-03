package day0703.UML;

public class CylinderTest {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        System.out.println("底面积:" + cylinder.findArea());
        System.out.println("体积:" + cylinder.findVolume());
        cylinder.setLength(3);
        cylinder.setRadius(2);
        System.out.println("底面积:" + cylinder.findArea());
        System.out.println("体积:" + cylinder.findVolume());

    }
}
