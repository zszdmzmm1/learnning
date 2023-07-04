package practice;


import java.util.*;

public class Solution {
    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，
     * 请你在该数组中找出和为目标值target的那两个整数，并返回它们的数组下标。
     */
    public int[] twoSum(int[] nums, int target) {
        int firstIndex = 0, secondIndex = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    firstIndex = i;
                    secondIndex = j;
                }
            }
        }
        return new int[]{firstIndex, secondIndex};
    }


    /**
     * 给你一个整数数组nums[] ，请计算数组的 中心下标 。
     * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
     * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
     * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1
     */
    public int pivotIndex(int[] nums) {
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                leftSum += nums[i - 1];
            }
            int rightSum = 0;
            for (int j = i + 1; j < nums.length; j++) {
                rightSum += nums[j];
            }
            if (rightSum == leftSum) {
                return i;
            }
        }
        return -1;
    }

    /*无需嵌套循环*/
    public int pivotIndexImprove(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum * 2 + nums[i] == sum) {
                return i;
            } else {
                leftSum += nums[i];
            }
        }
        return -1;
    }

    /* 无需嵌套循环plus*/
    public int pivotIndexImprove2(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
            if (leftSum == sum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }


    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
     * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     */
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    /*引入二分法*/
    public static int searchInsertImprove(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        /*相较于普通的二分法，需要额外处理无对应数据的情况*/
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return left;
    }


    /**
     * 以数组 intervals 表示若干个区间的集合，
     * 其中单个区间为 intervals[i] = [starti, endi] 。
     * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，
     * 该数组需恰好覆盖输入中的所有区间。
     */
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Map<Integer, int[]> map = new LinkedHashMap<>();
        int[][] result;
        int mapKey = 0;//用于判断是增加还是更新数组
        int left = intervals[0][0], right = intervals[0][1];
        map.put(mapKey, intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] > right){
                mapKey++;
                left = intervals[i][0];
                right = intervals[i][1];
            } else {
                left = Math.min(left, intervals[i][0]);
                right = Math.max(right, intervals[i][1]);
            }
            map.put(mapKey, new int[]{left, right});
        }
        //result = map.values().toArray(new int[map.size()][2]);
        Iterator<int[]> iterator = map.values().iterator();
        result = new int[map.size()][2];
        for (int j = 0; j < map.size(); j++) {
            result[j] = iterator.next();
        }
        return result;
    }


    public static int[][] mergeFaster(int[][] intervals) {
        if (intervals.length == 0) return intervals;
        //1、对二维数组按照第一列升序排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        //2、进行合并数组
        List<int[]> list = new ArrayList<>();
        int term[] = intervals[0];//临时空间，1 判断是否需要合并集合，2 是否放入结果集
        for (int i = 1; i < intervals.length; i++) {
            if (term[1] >= intervals[i][0]) {
                term[1] = Math.max(term[1], intervals[i][1]);
            } else {
                list.add(term);
                term = intervals[i];
            }
        }
        list.add(term);
        return list.toArray(new int[list.size()][2]);
    }
}
