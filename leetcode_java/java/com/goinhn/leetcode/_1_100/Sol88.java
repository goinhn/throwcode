package com.goinhn.leetcode._1_100;

/**
 * 88.合并两个有序数组
 *
 * @author goinhn
 * @date 2021/11/20
 */
public class Sol88 {

    /**
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int index = nums1.length - 1;
            int index1 = m - 1;
            int index2 = n - 1;
            while (index1 > -1 && index2 > -1) {
                if (nums1[index1] > nums2[index2]) {
                    nums1[index] = nums1[index1];
                    index1--;
                } else {
                    nums1[index] = nums2[index2];
                    index2--;
                }
                index--;
            }
            if (index2 > -1) {
                System.arraycopy(nums2, 0, nums1, 0, index2 + 1);
            }
        }
    }
}
