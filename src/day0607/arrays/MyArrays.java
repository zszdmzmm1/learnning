package day0607.arrays;

public class MyArrays {

    /**
     * @param arr int类型的数组
     * @return 数组的最大值
     */
    public static int max(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }


    /**
     * @param arr int类型的数组
     * @return 数组的最小值
     */
    public static int min(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }


    /**
     * @param arr int类型的数组
     * @return 数组元素总和
     */
    public static int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

        }
        return sum;
    }


    /**
     * 遍历整个数组打印，数组元素间用空格隔开
     *
     * @param arr int类型的数组
     */
    public static void printAll(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();
    }


    /**
     * @param arr int类型的数组
     * @return 数据类型为double， 值为数据元素的平均值
     */
    public static double average(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

        }
        return sum * 1.0 / arr.length;
    }


    /**
     * 在数组arr[]中寻找target，找到输出"found it!",
     *
     * @param arr    int类型的数组
     * @param target int类型的目标，在arr[]中寻找这个数
     */
    public static void search(int[] arr, int target) {
        int minNum = 0, maxNum = arr.length - 1;

        do {
            int index = (maxNum + minNum) / 2;

            /* maxNumy与minNum的加一减一是为了过滤index的影响，因为index已经被比对过，可以剔除
             * 倘若不这么做，数组末端元素的查找会出现错误
             * 当 (index = (maxNum + minNum) / 2)，时，右端的查找出错
             * 当 (index = (maxNum + minNum + 1) / 2)，时，左端的查找出错
             * 归根结底，是最后一次查找中，middle的结果是index，造成无限循环
             * index已经被排除，留下它造成潜在隐患
             */
            if (target == arr[index]) {
                System.out.println("found it!");
                break;
            } else if (target < arr[index]) {
                maxNum = index - 1;

            } else {
                minNum = index + 1;
            }
        } while (minNum <= maxNum);
    }


    /**
     * 将数组元素从小到大排序
     *
     * @param arrs int类型的数组
     */
    public static void sort(int[] arrs) {
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


    /**
     * 将数组元素顺序反转
     *
     * @param arr int类型的数组
     */
    public static void transvers(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }


    /**
     * 将数组arr1与arr2的元素交换
     * @param arr1 int类型数组
     * @param arr2 int类型数组
     */
    public static void arrSwitch(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            System.out.println("数组长度不同，无法交换！");
        }
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] += arr2[i];
            arr2[i] = arr1[i] - arr2[i];
            arr1[i] -= arr2[i];
        }
    }


}
