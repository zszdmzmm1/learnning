package day0704.singleton;

import org.junit.jupiter.api.Test;


class PersonTest {
    @Test
    void test1() {
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


    @Test
    void test2(){
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Person.getPerson().hashCode());
            }).start();
        }
    }

}