package com.goinhn.thorwcode.leetcode.question._1_100;

/**
 * 53.最大子序和
 *
 * @author goinhn
 * @date 2021-11-08
 **/
public class Sol53 {

    /**
     * 暴力破解法
     * <p>
     * time:O(n^2)
     * space:O(1)
     */
    private static class Solution1 {
        public int maxSubArray(int[] nums) {
            int max = nums[0];
            for (int left = 0; left < nums.length; left++) {
                int maxTemp = 0;
                for (int right = left; right < nums.length; right++) {
                    maxTemp += nums[right];
                    max = Math.max(max, maxTemp);
                }
            }
            return max;
        }
    }

    /**
     * 动态规划
     * <p>
     * time:O(n)
     * space:O(1)
     */
    private static class Solution2 {
        public int maxSubArray(int[] nums) {
            int pre = 0;
            int max = nums[0];
            for (int num : nums) {
                pre = Math.max(pre + num, num);
                max = Math.max(pre, max);
            }
            return max;
        }
    }

    /**
     * 分治法
     */
    private static class Solution3 {
        public int maxSubArray(int[] nums) {
            return 0;
        }
    }
}
