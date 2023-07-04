package day0613;
/**
 * HashSet在修改元素对象时会出现种种问题，以下的例子可见一斑。
 */

import day0613.student_infomation_typein.Student;

import java.util.HashSet;
import java.util.Set;


public class SetTest2 {
    public static void main(String[] args) {
        Set set = new HashSet();
        //Student重写了HashCode的equals()方法和hashCode()方法
        Student s1 = new Student("黄", 21);
        Student s2 = new Student("林", 23);
        Student s3 = new Student("朱", 20);

        set.add(s1);
        set.add(s2);
        set.add(s3);
        System.out.println(set);
        System.out.println();



        /*改变了对象的数据后，set通过修改后的对象计算的哈希值寻找对象，
        未能找到，没能清除对象*/
        s1.setAge(100);
        set.remove(s1);
        System.out.println(set);
        System.out.println();



        /*添加了一个和修改过后相同的对象，本不应该存储成功，
        但通过哈希值计算得出了一个新的数值，
        被存放到了其他地方，未调用eauals()方法*/
        set.add(new Student("黄", 100));
        System.out.println(set);

    }
}
