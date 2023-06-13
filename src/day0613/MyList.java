package day0613;


import com.sun.source.tree.ContinueTree;

import java.util.*;


public class MyList {
    public static void main(String[] args) {
        List<Character> letterList = new ArrayList<>();
        letterList.add('a');
        letterList.add('r');
        letterList.add('g');
        letterList.add('n');
        letterList.add('a');
        letterList.add('2');
        letterList.add('v');
        letterList.add('r');
        letterList.add('g');
        letterList.add('5');
        letterList.add('6');
        letterList.add('7');
        letterList.add('g');
        letterList.add('4');
        letterList.add('n');
        letterList.add('s');
        letterList.add('t');


        Map<Character, Integer> map = new HashMap<>();
        for (Character character : letterList) {
            if (!map.containsKey(character)) {
                map.put(character, 1);
                continue;
            }
            Integer num = map.get(character);
            num++;
            map.put(character, num);
        }
        Set<Map.Entry<Character,Integer>> charSet = map.entrySet();
        System.out.println(charSet);

    }
}
