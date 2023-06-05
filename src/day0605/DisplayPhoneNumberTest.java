package day0605;

public class DisplayPhoneNumberTest {
    public static void main(String[] args) {
        //17359105989
        int[] array1 = new int[] {1, 3, 5, 7, 8, 9, 0};
        int[] array2 = new int[] {0, 3, 1, 2, 5, 0, 6, 2, 5, 4, 5};
        for (int i = 0; i < array2.length; i++){
            System.out.print(array1[array2[i]]);
        }
        for (int j : array2) {
            System.out.print(array1[j]);
        }


    }
}
