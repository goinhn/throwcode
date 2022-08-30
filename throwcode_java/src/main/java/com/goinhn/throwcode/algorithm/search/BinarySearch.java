package com.goinhn.throwcode.algorithm.search;

/**
 * 二分查找
 *
 * @author goinhn
 * @date 2022/8/30
 */
public class BinarySearch {

    /**
     * time:O(logn)
     * space:O(1)
     */
    private static class Solution1 {
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }

            int l = 0;
            int r = nums.length - 1;
            while (l <= r) {
                int m = (l + r) / 2;
                if (nums[m] > target) {
                    r = m - 1;
                } else if (nums[m] < target) {
                    l = m + 1;
                } else {
                    return m;
                }
            }

            return -1;
        }
    }

}
