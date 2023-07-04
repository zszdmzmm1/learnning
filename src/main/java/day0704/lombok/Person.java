package day0704.lombok;


/*@Getter
@Setter
@AllArgsConstructor*/

public class Person {
    private String name;
    private int age;
    private String id;
    private static Person person = new Person();


    private Person() {
    }

    public static Person getPerson(){
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
