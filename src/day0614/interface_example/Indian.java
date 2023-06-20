package day0614.interface_example;

public class Indian implements Eatable{
    private String name;

    public Indian(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println("用手抓饭。");
    }

    @Override
    public String toString() {
        return "Indian{" +
                "name='" + name + '\'' +
                '}';
    }
}
