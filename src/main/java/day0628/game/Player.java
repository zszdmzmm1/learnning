package day0628.game;

public class Player extends LivingBeing{

    @Override
    public void walk() {
        System.out.println(this.getClass().getSimpleName() + "行走了" + "60cm。");
    }

}
