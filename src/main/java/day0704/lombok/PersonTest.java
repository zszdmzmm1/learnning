package day0704.lombok;

public class PersonTest {
    public static void main(String[] args) {

        Person person1 = Person.getPerson();
        Person person2 = Person.getPerson();
        Person person3 = Person.getPerson();
        Person person4 = Person.getPerson();
        Person person5 = Person.getPerson();


        System.out.println(person1 == person2);
        System.out.println(person3 == person2);
        System.out.println(person3 == person4);
        System.out.println(person5 == person4);



    }
}
