package day0606;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arrs = new int[]{-2, 45, 0, 11, -9, 23, 11, -11};
        for (int arr : arrs) {
            System.out.print(arr + " ");
        }
        System.out.println();

        int temp;
        for (int i = 0; i < arrs.length - 1; i++) {
            for (int j = 0; j < arrs.length - i - 1; j++) {
                if (arrs[j] > arrs[j + 1]) {
                    temp = arrs[j];
                    arrs[j] = arrs[j + 1];

                    arrs[j + 1] = temp;
                }
            }
        }
        for (int arr : arrs) {
            System.out.print(arr + " ");
        }
    }
}
