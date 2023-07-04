package day0629;

import day0613.student_infomation_typein.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static day0629.Test.Collections.copy;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list.add(123);
        list.add(123);
        list.add(123);
        copy(list1,list );
        System.out.println(list1);



    }


    public class Collections {
        // 把src的每个元素复制到dest中:
        public static <T> void copy(List<? super T> dest, List<? extends T> src) {
            for (int i=0; i<src.size(); i++) {
                T t = src.get(i);
                dest.add(t);
            }
        }
    }
}
