package com.goinhn.thorwcode.leetcode.question._1_100;

/**
 * 45.跳跃游戏II
 *
 * @author goinhn
 * @date 2022/10/6
 */
public class Sol45 {

    /**
     * 贪心
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {

        public int jump(int[] nums) {
            int step = 0;
            int maxPos = 0;
            int end = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                maxPos = Math.max(maxPos, i + nums[i]);
                if (i == end) {
                    end = maxPos;
                    step++;
                }
            }

            return step;
        }

    }

}
