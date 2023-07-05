package day0704.singleton;


/*@Getter
@Setter
@AllArgsConstructor*/

public class Person {
    private static volatile Person person;


    private Person() {

    }

    public static Person getPerson() {
        if (person == null) {
            synchronized ("a") {
                if (person == null) {
/*                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }*/
                    person = new Person();
                }
            }
        }
        return person;
    }
}
