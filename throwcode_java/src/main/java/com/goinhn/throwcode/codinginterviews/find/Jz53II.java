package com.goinhn.throwcode.codinginterviews.find;

/**
 * 53II.在排序数组中查找数字
 *
 * @author goinhn
 * @date 2021/12/27
 */
public class Jz53II {

    /**
     * 二分法
     * time:O(logn)
     * space:O(1)
     */
    private static class Solution1 {
        public int missingNumber(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int middle = (left + right) >> 1;
                if (nums[middle] > middle) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
            return left;
        }
    }
}

