package day0614.interface_example;

public class American implements Eatable{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public American(String name) {
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println("用刀叉吃饭。");
    }

    @Override
    public String toString() {
        return "American{" +
                "name='" + name + '\'' +
                '}';
    }
}
