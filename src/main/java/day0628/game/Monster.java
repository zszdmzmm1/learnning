package day0628.game;

public class Monster extends LivingBeing{

    @Override
    public void attact() {
        System.out.println(this.getClass().getSimpleName() + "造成了120点伤害。");
    }

}
