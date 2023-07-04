package day0614.interface_example;

/**
 * 接口的简单例子与测试
 */

public class EatableTest {
    public static void main(String[] args) {
        Eatable[] eatables = new Eatable[3];
        eatables[0] = new Chinese("林世豪");
        eatables[1] = new Indian("甘地");
        eatables[2] = new American("川建郭");
        for (Eatable eatabkle : eatables) {
            System.out.println(eatabkle);
            eatabkle.eat();
        }
    }
}
