package day0615;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        List<String> character = new ArrayList<>();
        character.add("黄药师");
        character.add("冯蘅");
        character.add("郭靖");
        character.add("黄蓉");
        character.add("郭芙");
        character.add("郭襄");
        character.add("郭破虏");
        //List<String> newCharctor = character.stream().filter(item -> Objects.equals(item.charAt(0), '郭')).collect(Collectors.toList());
        List<String> newCharctor = character.stream().filter(item -> item.startsWith("郭")).collect(Collectors.toList());
        System.out.println(newCharctor);
        System.out.println();
        System.out.println("-------");
        System.out.println();



        List<String> charactor1 = new ArrayList<>();
        charactor1.add("陈玄风");
        charactor1.add("梅超风");
        charactor1.add("陆乘风");
        charactor1.add("曲灵风");
        charactor1.add("武眠风");
        charactor1.add("冯默风");
        charactor1.add("罗玉凤");
        charactor1.stream().limit(2).forEach(System.out::println);
        System.out.println();
        System.out.println("-------");
        System.out.println();
        charactor1.stream().skip(charactor1.size() - 2).forEach(System.out::println);


        List<Integer> forAbs = new ArrayList<>();
        forAbs.add(1);
        forAbs.add(-2);
        forAbs.add(-3);
        forAbs.add(4);
        forAbs.add(-5);
        forAbs.stream().map(item -> Math.abs(item)).forEach(System.out::println);
        System.out.println("----------");

        List<Integer> forPow = new ArrayList<>();
        forPow.add(1);
        forPow.add(2);
        forPow.add(3);
        forPow.add(4);
        forPow.add(5);
        forPow.stream().map(item -> Math.pow(item, 2)).forEach(System.out::println);
        /*List<Double> newForPowforAbs = forPow.stream().map(item -> Math.pow(item,2)).collect(Collectors.toList());
        System.out.println(newForPowforAbs);*/

    }
}
