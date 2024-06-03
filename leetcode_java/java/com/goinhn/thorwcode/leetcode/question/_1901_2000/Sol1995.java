package com.goinhn.thorwcode.leetcode.question._1901_2000;

/**
 * 1995.统计特殊四元组
 *
 * @author goinhn
 * @date 2023/1/5
 */
public class Sol1995 {

    /**
     * cycle of violence
     * time:O(n^4)
     * space:O(1)
     */
    private static class Solution1 {
        public int countQuadruplets(int[] nums) {
            int count = 0;
            int l = nums.length;
            for (int i = 0; i < l - 3; i++) {
                for (int j = i + 1; j < l - 2; j++) {
                    for (int m = j + 1; m < l - 1; m++) {
                        for (int n = m + 1; n < l; n++) {
                            if (nums[i] + nums[j] + nums[m] == nums[n]) {
                                count++;
                            }
                        }
                    }
                }
            }
            return count;
        }
    }
}
