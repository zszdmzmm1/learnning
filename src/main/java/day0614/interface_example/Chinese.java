package day0614.interface_example;

public class Chinese implements Eatable{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Chinese(String name) {
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println("用筷子吃饭。");
    }

    @Override
    public String toString() {
        return "Chinese{" +
                "name='" + name + '\'' +
                '}';
    }
}
