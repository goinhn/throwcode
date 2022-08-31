package com.goinhn.thorwcode.leetcode.question._801_900;

/**
 * 852.山脉数组的峰顶索引
 *
 * @author goinhn
 * @date 2022/8/31
 */
public class Sol852 {

    /**
     * 遍历
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {

        public int peakIndexInMountainArray(int[] arr) {
            for (int i = 1; i < arr.length - 1; i++) {
                if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    return i;
                }
            }

            return -1;
        }

    }

    /**
     * 二分
     * time:O(logn)
     * space:O(1)
     */
    private static class Solution2 {

        public int peakIndexInMountainArray(int[] arr) {
            int left = 0;
            int right = arr.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] <= arr[mid + 1]) {
                    left = mid + 1;
                } else if (arr[mid] <= arr[mid - 1]) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            }

            return -1;
        }

    }

}
