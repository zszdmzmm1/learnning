package day0613;
/**
 * List内去除重复数字值
 */

import java.util.*;

public class SetTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        List<Integer> list = new ArrayList<>();
        do {
            System.out.println("请输入一个数字：");
            num = sc.nextInt();
            list.add(num);
            System.out.println("停止输入请按0,继续输入请按任意数");
            if (sc.nextInt() == 0) {
                break;
            }
        } while (true);
        System.out.println(duplicateList(list));
    }

    public static List duplicateList(List list) {
        Set set = new HashSet(list);
        List newList = new ArrayList(set);
        return list;
    }
}

