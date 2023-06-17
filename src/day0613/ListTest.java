package day0613;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ListTest {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        List list1 = new ArrayList<>();


        System.out.println("-----增：");

        list.add(1);
        list.add("黄");
        System.out.println("list = " + list);
        list1.addAll(list);
        System.out.println("list1 = " + list1);

        System.out.println();
        /*删*/
        /*remove(Objects obj) remove(index int)*/
        //下一行代码删除哪个元素呢？
        //list1.remove(1);
        /*list1.remove(Integer.valueOf(1))*/

        /*改*/
        System.out.println("-----改：");

        list.set(1, "俊");

        System.out.println("list = " + list);
        System.out.println();
        /*查*/
        System.out.println("-----查：");

        list.get(0);

        System.out.println("list = " + list);
        System.out.println();
        /*插*/
        System.out.println("-----插：");

        list.add(1, 42);
        list.addAll(2, list1);
        System.out.println("list = " + list);

        System.out.println();
        /*长度*/
        System.out.println("-----长度：");

        System.out.println(list.size());

        System.out.println();

        /*遍历*/
        System.out.println("-----遍历：");

        //一
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }

        System.out.println();

        //二
        for (Object li :list) {
            System.out.print(li + " ");
        }

        System.out.println();
    }
}
