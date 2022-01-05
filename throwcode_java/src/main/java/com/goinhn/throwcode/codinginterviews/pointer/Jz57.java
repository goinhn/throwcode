package com.goinhn.throwcode.codinginterviews.pointer;

/**
 * 57.和为s的两个数字
 *
 * @author goinhn
 * @date 2022/1/5
 */
public class Jz57 {

    /**
     * 双端指针
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {
        public int[] twoSum(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] < target) {
                    left++;
                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    return new int[]{nums[left], nums[right]};
                }
            }
            return null;
        }
    }
}

