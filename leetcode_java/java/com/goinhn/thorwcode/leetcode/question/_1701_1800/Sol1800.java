package com.goinhn.thorwcode.leetcode.question._1701_1800;

/**
 * 1800.最大升序子数组和
 *
 * @author goinhn
 * @date 2022/10/7
 */
public class Sol1800 {

    /**
     * 模拟
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {

        public int maxAscendingSum(int[] nums) {
            int max = nums[0];
            int sub = nums[0];
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i + 1] > nums[i]) {
                    sub += nums[i + 1];
                    max = Math.max(max, sub);
                } else {
                    sub = nums[i + 1];
                }
            }

            return max;
        }

    }
}
