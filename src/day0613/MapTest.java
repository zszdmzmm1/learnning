package day0613;

import day0609.rockpaperscissors.Player;
import day0613.student_infomation_typein.Student;

import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        Map map = new HashMap();
        Map map1 = new HashMap();
        Map map2 = new HashMap();
        Map map3 = new HashMap();


        System.out.println("-----put(Object key, Object value)、size()--------");
        map.put(12, "aa");
        map.put(null, 56);//可放入null值
        map.put("dd", 1);
        map.put("黄", "greatest");
        /*put(Object key, Object value)也可用于修改或更新*/
        //Object value = map.put(12, "not aa");
        /*返回修改前的值*/
        //System.out.println(value);
        map.put(new Student("Ted", 30), "HIMYM");
        System.out.println(map);
        System.out.println(map.size());
        System.out.println();

        System.out.println("-----putAll()----");
        map1.putAll(map);
        System.out.println(map1);
        System.out.println();


        System.out.println("-----remove(Object key)------");
        System.out.println(map.remove("dd"));//返回value值
        System.out.println(map);
        System.out.println();

        System.out.println("-----get(Object key)--------");
        System.out.println(map.get(12));
        System.out.println();


        System.out.println("-----遍历------------------------");
        System.out.println("遍历key:");
        Set keyset = map.keySet();
        Iterator iterator = keyset.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
/*        for(Object o: keyset){
            System.out.println(o);
        }*/

        System.out.println();
        System.out.println("遍历values:");
        Collection collection = map.values();
        for(Object o:collection){
            System.out.println(o);
        }

/*        for(Object o: keyset){
            System.out.println(map.get(o));
        }*/

        System.out.println();
        System.out.println("遍历entrySet：");
        Set entrySet = map.entrySet();
        Iterator iterator2 = entrySet.iterator();
        while(iterator2.hasNext()){
            Map.Entry mapEntry = (Map.Entry)iterator2.next();
            System.out.println(mapEntry.getKey() + "  >>>>>  " + mapEntry.getValue());
            //System.out.println(iterator2.next());
        }


    }
}
