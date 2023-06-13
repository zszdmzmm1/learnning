package day0613;


import java.util.*;


public class MyList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
        System.out.println(letterList);


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
        Set<Map.Entry<Character, Integer>> charSet = map.entrySet();
        System.out.println(charSet);

        for (Map.Entry<Character, Integer> h : charSet) {
            System.out.println(h.getKey() + ":" + h.getValue());
        }
    }
}
