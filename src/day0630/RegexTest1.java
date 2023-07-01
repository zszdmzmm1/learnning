package day0630;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest1 {
    public static void main(String[] args) {
        String s = "Hello, ${name}! You are learning ${lang}!";
        Pattern pattern = Pattern.compile("\\$\\{\\w*?\\}");
        Matcher matcher = pattern.matcher(s);
        Map<String, String> map = new HashMap<>();
        map.put("name", "Bob");
        map.put("lang", "Chinese");
        String result = s;
        while(matcher.find()){
            String sub = s.substring(matcher.start() + 2, matcher.end() - 1);
            result = result.replace("${" + sub + "}", map.get(sub));
        }
        System.out.println(result);
    }
}
