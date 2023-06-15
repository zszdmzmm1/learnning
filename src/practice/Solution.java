package practice;


public class Solution {
    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值target的那两个整数，并返回它们的数组下标。
     *
     * @param nums
     * @param target
     * @return
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
     *
     * @param nums 整数数组
     * @return 中心下标
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
            }else{
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
            if(leftSum == sum){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }



}
