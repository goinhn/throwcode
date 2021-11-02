package com.goinhn.leetcode._1_100._1_10;

/**
 * 1. 两数之和
 *
 * @author goinhn
 * @date 2020-08-29
 */
public class Sol1 {

    /**
     * 直接使用两遍循环判断是否有和等于目标值的数字
     * <p>
     * time:O(n^2)
     * space:O(1)
     */
    private static class Solution {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                int another = target - nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == another) {
                        return new int[]{i, j};
                    }
                }
            }

            throw new IllegalArgumentException("no two sum numbers");
        }
    }


}
