package com.goinhn.throwcode.codinginterviews.dynamic_programming;

/**
 * 42.连续子数组的最大和
 *
 * @author goinhn
 * @date 2022/1/1
 */
public class Jz42 {

    /**
     * 迭代、动态规划
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {
        public int maxSubArray(int[] nums) {
            int[] dp = new int[nums.length];
            int maxNum = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
                maxNum = Math.max(dp[i], maxNum);
            }
            return maxNum;
        }
    }

    /**
     * 迭代、动态规划，进一步压缩空间
     * time:O(n)
     * space:O(1)
     */
    private static class Solution2 {
        public int maxSubArray(int[] nums) {
            int maxNum = nums[0];
            int preNum = nums[0];
            for (int i = 1; i < nums.length; i++) {
                preNum = Math.max(preNum + nums[i], nums[i]);
                maxNum = Math.max(preNum, maxNum);
            }
            return maxNum;
        }
    }

}

