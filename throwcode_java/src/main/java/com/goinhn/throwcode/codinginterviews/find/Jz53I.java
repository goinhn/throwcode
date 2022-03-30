package com.goinhn.throwcode.codinginterviews.find;

/**
 * 53I.在排序数组中查找数字
 *
 * @author goinhn
 * @date 2021/12/27
 */
public class Jz53I {

    /**
     * 二分法
     * time:O(logn)
     * space:O(1)
     */
    private static class Solution1 {
        public int search(int[] nums, int target) {
            if (nums.length == 0) {
                return 0;
            }

            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int middle = (left + right) >> 1;
                if (nums[middle] >= target) {
                    right = middle;
                } else {
                    left = middle + 1;
                }
            }
            if (nums[left] != target) {
                return 0;
            }
            int lower = left;

            left = 0;
            right = nums.length - 1;
            while (left < right) {
                int middle = (left + right + 1) >> 1;
                if (nums[middle] <= target) {
                    left = middle;
                } else {
                    right = middle - 1;
                }
            }
            if (nums[right] != target) {
                return 0;
            }
            int higher = right;

            return higher - lower + 1;
        }
    }
}

