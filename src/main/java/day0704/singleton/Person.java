package day0704.singleton;


/*@Getter
@Setter
@AllArgsConstructor*/

import static java.lang.Thread.sleep;

public class Person {
    private String name;
    private int age;
    private String id;
    private static Person person;



    private Person() {

    }

    public static synchronized Person getPerson(){
        if(person == null) {
            person = new Person();
        }
        return person;
    }
/*
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }*/
}
