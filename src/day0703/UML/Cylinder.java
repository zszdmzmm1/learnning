package day0703.UML;

public class Cylinder extends Circle {
    private double length;

    public Cylinder() {
        length = 1;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double findArea() {
        double radius = getRadius();
        return Math.PI * (2 * radius) * length + 2 * Math.PI * radius * radius;
    }

    public double findVolume(){
        return super.findArea() * length;
    }

    @Override
    public double getRadius() {
        return super.getRadius();
    }
}
