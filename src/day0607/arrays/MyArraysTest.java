package day0607.arrays;

public class MyArraysTest {
    public static void main(String[] args) {
        int[] arr = {4, 45, 454, 2, 13, 46, 567, 67, 68, 6, 34, 3, -535, -5345, -45, -1, -5};
        int[] arr1 = {3, 43, 43, 45, 56, 67, 78, 7, 4324, 45, 23, 32, 23, 23, 23, 34, 343};
//        MyArrays.transvers(arr);
        MyArrays.printAll(arr);
        MyArrays.printAll(arr1);

        MyArrays.arrSwitch(arr, arr1);
        MyArrays.printAll(arr);
        MyArrays.printAll(arr1);
    }
}
