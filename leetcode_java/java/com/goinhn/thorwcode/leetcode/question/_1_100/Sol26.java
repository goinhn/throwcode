package com.goinhn.thorwcode.leetcode.question._1_100;

import java.util.Arrays;

/**
 * 26.删除有序数组中的重复项
 *
 * @author goinhn
 * @date 2021-11-05
 **/
public class Sol26 {

    /**
     * 双指针
     *
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {
        public int removeDuplicates(int[] nums) {
            int index = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[index]) {
                    index++;
                    nums[index] = nums[i];
                }
            }

            return index + 1;
        }
    }

    private static class Solution2 {
        public int removeDuplicates(int[] nums) {
            int[] temp = Arrays.stream(nums).distinct().toArray();
            System.arraycopy(temp, 0, nums, 0, temp.length);
            return temp.length;
        }
    }
}
