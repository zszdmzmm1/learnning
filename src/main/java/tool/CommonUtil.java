package tool;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class CommonUtil {
    /**
     *
     * @param s
     * @param pattern
     * @return
     */
    public static String[] match(String s, String pattern) {
        Matcher m = Pattern.compile(pattern).matcher(s);

        while (m.find()) {
            int n = m.groupCount();
            String[] ss = new String[n + 1];
            for (int i = 0; i <= n; i++) {
                ss[i] = m.group(i);
            }
            return ss;
        }
        return null;
    }


/*    public static String matchedThenGetDollarOne(String s, String pattern){
        String[] ss = CommonUtil.match(s,pattern);
        if(ss!=null && ss.length>0){
            return ss[1];
        }else {
            return null;
        }
    }*/
}
