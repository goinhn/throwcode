package com.goinhn.thorwcode.leetcode.question._201_300;

import java.util.ArrayList;
import java.util.List;

/**
 * 228.汇总区间
 *
 * @author goinhn
 * @date 2021/12/12
 */
public class Sol228 {

    /**
     * 双指针
     * <p>
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {
        public List<String> summaryRanges(int[] nums) {
            List<String> result = new ArrayList<>();
            int lowIndex = 0;
            int highIndex = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i == nums.length - 1 || nums[i] + 1 < nums[i + 1]) {
                    if (lowIndex == highIndex) {
                        result.add(nums[lowIndex] + "");
                    } else {
                        result.add(nums[lowIndex] + "->" + nums[highIndex]);
                    }
                    lowIndex = i + 1;
                    highIndex = i + 1;
                } else {
                    highIndex++;
                }
            }
            return result;
        }
    }
}
