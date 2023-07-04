package day0628.game;

public class LivingBeing implements ILivingBeing{
    @Override
    public void walk() {
        System.out.println(this.getClass().getSimpleName() + "行走了" + "50cm。");
    }

    @Override
    public void attact() {
        System.out.println(this.getClass().getSimpleName() + "造成了100点伤害。");
    }

    @Override
    public void dead() {
        /////////
        System.out.println(this.getClass().getSimpleName() + "已死亡。");
    }
}
