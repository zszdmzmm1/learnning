package day0613;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionTest {
    public static void main(String[] args) {
        Collection coll = new ArrayList();
        Collection coll1 = new ArrayList();
        Collection coll2 = new ArrayList();
        Collection coll3 = new ArrayList();


        System.out.println("-----add(Object obj)---------------------");
        coll.add("fight");
        coll.add(123);
        coll.add(new Object());
        coll.add(new day0608.student.Student());
        coll1.add("hfjd");
        System.out.println(coll);


        System.out.println();
        System.out.println("-----addAll(Collection coll)-------------------------------------");
        coll1.addAll(coll);
        coll2.addAll(coll);
        System.out.println(coll1);

        System.out.println();
        System.out.println("-----size()----------------------------------");
        System.out.println(coll.size());
        System.out.println(coll1.size());

        System.out.println();
        System.out.println("-----isEmpty()-----------------------------------");
        System.out.println(coll.isEmpty());
        System.out.println(coll3.isEmpty());


        System.out.println();
        System.out.println("-----contains(Object obj)------------------------");
        //调的是object.equal()
        System.out.println(coll.contains(123));
        System.out.println(coll.contains(128));

        System.out.println();
        System.out.println("-----containsAll()--------------------");
        System.out.println(coll1.containsAll(coll));


        System.out.println();
        System.out.println("-----equals()---------------");
        System.out.println(coll.equals(coll2));


        System.out.println();
        System.out.println("-----clear()------------");
        coll2.clear();
        System.out.println(coll2);
        System.out.println(coll2.size());


        System.out.println();
        System.out.println("-----remove(Object obj)---------");
        coll1.remove(123);
        System.out.println(coll1);

        System.out.println();
        System.out.println("-----removeAll(Collection coll)---------");
        //删除公共部分
        coll1.removeAll(coll);
        System.out.println(coll1);

        System.out.println();
        System.out.println("-----retainAll(Collection coll)-------");
        //保留交集
        coll1.addAll(coll);
        coll1.retainAll(coll);
        System.out.println(coll1);


        System.out.println();
        System.out.println("-----集合 -> 数组----------");
        Object[] arr = coll.toArray();
        System.out.println(arr[1]);


        System.out.println();
        System.out.println("-----hashCode()--------");
        //计算哈希值
        System.out.println(coll.hashCode());


        System.out.println();
        System.out.println("-----数组 -> 集合----------");
        String[] arr1 = new String[]{"1", "2", "3", "4"};
        Collection coll4 = Arrays.asList(arr1);
        System.out.println(coll4);


        /*collection里装的是对象，不可以是基本数据类型*/
        Collection coll5 = Arrays.asList(new int[]{1, 2, 3});
        Collection coll6 = Arrays.asList(new Integer[]{1, 2, 3});
        System.out.println();
        System.out.println("-----判断下列值");
        /*1
        地址
        3
        [1, 2, 3]*/
        System.out.println(coll5.size());
        System.out.println(coll5);
        System.out.println(coll6.size());
        System.out.println(coll6);


    }
}
