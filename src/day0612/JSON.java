package day0612;

import com.google.gson.Gson;
import day0605.Array;

import java.util.*;

public class JSON {
    public static void main(String[] args) {
        AJson user1 = new AJson("h", 1);
        AJson user2 = new AJson("g", 2);
        AJson user3 = new AJson("p", 3);
        List<AJson> user = new ArrayList();
        user.add(user1);
        user.add(user2);
        user.add(user3);
        Gson s = new Gson();
        String ss = s.toJson(user);
        List sss = s.fromJson(ss, List.class);
        System.out.println(ss);
    }
}

class AJson {
    private String name;
    private int uid;

    public AJson(String name, int uid) {
        this.name = name;
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUID() {
        return uid;
    }

    public void setUID(int uid) {
        this.uid = uid;
    }
}
