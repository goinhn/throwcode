package com.goinhn.throwcode.codinginterviews.find;

import java.util.HashSet;
import java.util.Set;

/**
 * 3.数组中重复的数字
 *
 * @author goinhn
 * @date 2021/12/24
 */
public class Jz3 {

    /**
     * 哈希表
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {
        public int findRepeatNumber(int[] nums) {
            Set<Integer> numSet = new HashSet<>();
            for (int num : nums) {
                if (numSet.contains(num)) {
                    return num;
                }
                numSet.add(num);
            }
            return -1;
        }
    }

    /**
     * 原地交换
     * time:O(n)
     * space:O(1)
     */
    private static class Solution2 {
        public int findRepeatNumber(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == i) {
                    continue;
                }
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
                i--;
            }
            return -1;
        }

        private void swap(int[] nums, int x, int y) {
            int temp = nums[x];
            nums[x] = nums[y];
            nums[y] = temp;
        }
    }

}

