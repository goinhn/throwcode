package com.goinhn.thorwcode.leetcode.question._101_200;

/**
 * 198.打劫家舍
 *
 * @author goinhn
 * @date 2022/8/4
 */
public class Sol198 {

    /**
     * 动态规划：dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {

        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            if (nums.length == 1) {
                return nums[0];
            }

            int first = nums[0];
            int two = Math.max(nums[0], nums[1]);
            for (int i = 2; i < nums.length; i++) {
                int temp = two;
                two = Math.max(first + nums[i], two);
                first = temp;
            }

            return two;
        }

    }

    /**
     * 递归搜索
     * time:O(2^(n/2))
     * space:O(2^(n/2))
     */
    private static class Solution2 {

        private int max;

        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            max = 0;

            dfs(nums, 0, 0, true);

            return max;
        }


        private void dfs(int[] nums, int idx, int sum, boolean flag) {
            if (idx >= nums.length) {
                max = Math.max(max, sum);
                return;
            }

            if (flag) {
                dfs(nums, idx + 1, sum + nums[idx], false);
            }

            dfs(nums, idx + 1, sum, true);
        }

    }

}
