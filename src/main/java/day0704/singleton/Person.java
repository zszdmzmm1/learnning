package day0704.singleton;


/*@Getter
@Setter
@AllArgsConstructor*/

public class Person {


    private Person() {

    }

    private static final class PersonHolder {
        private static final Person person = new Person();
    }


    public static Person getPerson() {
        return PersonHolder.person;
    }
}
