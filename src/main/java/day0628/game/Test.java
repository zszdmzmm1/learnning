package day0628.game;

public class Test {
    public static void main(String[] args) {
        Player player = new Player();
        Monster monster = new Monster();
        Solider solider = new Solider();
        player.walk();
        player.attact();
        player.dead();
        monster.walk();
        monster.attact();
        monster.dead();
        solider.attact();
        solider.walk();
        solider.dead();

    }
}
