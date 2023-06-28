package day0627;

public class ClassAbout {
    public static void main(String[] args) throws Exception {
        Person person = new Person();

        System.out.println(Person.class);
        System.out.println(person.getClass());

        String path = "day0627.Person";
        System.out.println(Class.forName(path));

        Class cls = Person.class;
        Class cls1 = Person.class;

        Object object = cls.getDeclaredConstructor().newInstance();
    }
}

class Person {
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}

class Person1 {
    private String name;

    public Person1() {
    }

    public Person1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}