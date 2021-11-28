package com.goinhn.thorwcode.leetcode.question._101_200;

import java.util.ArrayList;
import java.util.List;

/**
 * 163.缺失的区间
 *
 * @author goinhn
 * @date 2021/11/28
 */
public class Sol163 {

    private static class Solution1 {
        public List<String> findMissingRanges(int[] nums, int lower, int upper) {
            List<String> resultList = new ArrayList<>();
            if (nums.length == 0) {
                resultList.add(lower + "->" + upper);
                return resultList;
            }

            for (int i = -1; i < nums.length; i++) {
                String interval = null;
                if (i == -1) {
                    interval = getInterval(lower, nums[0]);
                } else if (i == nums.length - 1) {
                    interval = getInterval(nums[nums.length - 1], upper);
                } else {
                    interval = getInterval(nums[i - 1], nums[i]);
                }
                resultList.add(interval);
            }

            return resultList;
        }

        private String getInterval(int leftNum, int rightNum) {
            if (rightNum - leftNum <= 0) {
                return null;
            }
            return leftNum + "->" + rightNum;
        }
    }
}
