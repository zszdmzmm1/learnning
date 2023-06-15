package day0613;


import java.util.*;

/**
 * 输入一串String，输出每个字母数字有几个
 */


public class CountCharactor {
    public static void main(String[] args) {
        System.out.print("请输入一串字符：");
        /*拆分并最终放入List中*/
        Scanner sc = new Scanner(System.in);
        char[] letter = sc.next().toCharArray();
        Character[] cLetter = new Character[letter.length];
        for (int i = 0; i < cLetter.length; i++) {
            cLetter[i] = letter[i];
        }
        List<Character> letterList = Arrays.asList(cLetter);



        Map<Character, Integer> map = new HashMap<>();
        /*遍历List在Map中添加，更新*/
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

        for (Map.Entry<Character, Integer> h : charSet) {
            System.out.println(h.getKey() + ":" + h.getValue());
        }
    }
}
