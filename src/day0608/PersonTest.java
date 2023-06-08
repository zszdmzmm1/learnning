package day0608;

public class PersonTest {
    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(199);
        System.out.println(person.getAge());
    }
}


class Person {
    String name;
    private int age;


    public void setAge(int age){
        if(age < 0 || age >200){
            System.out.println("年龄错误！");
            return;
        }
        this.age = age;
    }

    public int getAge(){
        return age;
    }
}
