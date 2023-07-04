package day0606;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 6, 7, 8, 9};
        int minNum = 0, maxNum = arr.length - 1;
        int target = 8;

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
}
