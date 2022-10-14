package com.goinhn.thorwcode.leetcode.question._301_400;

/**
 * 334.递增的三元子序列
 *
 * @author goinhn
 * @date 2022/10/13
 */
public class Sol334 {

    /**
     * 贪心
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {

        public boolean increasingTriplet(int[] nums) {
            int first = nums[0];
            int second = Integer.MAX_VALUE;
            for (int num : nums) {
                if (num <= first) {
                    first = num;
                } else if (num <= second) {
                    second = num;
                } else {
                    return true;
                }
            }

            return false;
        }

    }
}
