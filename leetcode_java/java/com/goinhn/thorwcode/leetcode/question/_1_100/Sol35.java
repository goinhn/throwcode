package com.goinhn.thorwcode.leetcode.question._1_100;

/**
 * 35.搜索插入位置
 *
 * @author goinhn
 * @date 2021-11-06
 **/
public class Sol35 {

    /**
     * 先写出二分查找，再进行改造，注意边界条件
     * time:O(logn)
     * space:O(1)
     */
    private static class Solution1 {
        public int searchInsert(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            int result = nums.length;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (target < nums[mid]) {
                    right = mid - 1;
                    result = mid;
                } else if (target > nums[mid]) {
                    left = mid + 1;
                    result = left;
                } else {
                    return mid;
                }
            }

            return result;
        }
    }

    /**
     * time:O(logn)
     * space:O(1)
     */
    private static class Solution2 {
        public int searchInsert(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            int result = nums.length;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (target <= nums[mid]) {
                    right = mid - 1;
                    result = mid;
                } else {
                    left = mid + 1;
                }
            }

            return result;
        }
    }
}
