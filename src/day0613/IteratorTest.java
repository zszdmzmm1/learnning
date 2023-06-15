package day0613;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class IteratorTest {
    public static void main(String[] args) {
        Collection coll = new ArrayList();
        String[] forTest = new String[]{"周杰伦", "汪峰", "黄龄", "陈奕迅", "邓紫棋"};
        coll.addAll(Arrays.asList(forTest));

        //获取迭代器
        Iterator singerIterator = coll.iterator();


        //遍历：五个元素，调用5次。


        //1：
        /*System.out.println(singerIterator.next());
        System.out.println(singerIterator.next());
        System.out.println(singerIterator.next());
        System.out.println(singerIterator.next());
        System.out.println(singerIterator.next());
        System.out.println();*/

        //超出元素数量，报错：NoSuchElementException
        //System.out.println(singerIterator.next());

        //2.
        /*for (int i = 0; i < coll.size(); i++) {
            System.out.println(singerIterator.next());
        }
        System.out.println();*/


        //3.
        while(singerIterator.hasNext()){
            System.out.println(singerIterator.next());
        }
        System.out.println();

    }
}
