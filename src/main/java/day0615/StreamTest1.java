package day0615;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest1 {
    public static void main(String[] args) {
        ArrayList<String> actor = new ArrayList<>();
        actor.add("刘德华");
        actor.add("成龙");
        actor.add("吴彦祖");
        actor.add("周润发");
        actor.add("周星驰");
        actor.add("吴京");
        ArrayList<String> actress = new ArrayList<>();
        actress.add("林心如");
        actress.add("孙俪");
        actress.add("柳岩");
        actress.add("林青霞");
        actress.add("王祖贤");
        actress.add("张曼玉");

        List<String> newActor = actor.stream().filter(item -> item.length() == 3).limit(3).collect(Collectors.toList());
        List<String> newActress = actress.stream().filter(item -> Objects.equals(item.charAt(0), '林')).skip(1).collect(Collectors.toList());

        System.out.println(newActor);
        System.out.println("----------");
        System.out.println(newActress);
        System.out.println("----------");

        List<String> finalActor = new ArrayList<>();
        finalActor.addAll(newActor);
        finalActor.addAll(newActress);
        System.out.println(finalActor);

        Stream.concat(newActor.stream(), newActress.stream()).map(Actor::new).forEach(p -> System.out.println(p.getName()));



    }
}
class Actor {
    private String name;

    public Actor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
