package com.goinhn.thorwcode.leetcode.competition.biweeklycontest._76;

/**
 * @author goinhn
 * @date 2022/4/16
 */
public class Sol1 {

    private static class Solution1 {
        public int findClosestNumber(int[] nums) {
            int closeDistance = Integer.MAX_VALUE;
            for (int num : nums) {
                if (Math.abs(num) < Math.abs(closeDistance)) {
                    closeDistance = num;
                }
                if (Math.abs(num) == Math.abs(closeDistance) && num > closeDistance) {
                    closeDistance = num;
                }
            }
            return closeDistance;
        }
    }
}
