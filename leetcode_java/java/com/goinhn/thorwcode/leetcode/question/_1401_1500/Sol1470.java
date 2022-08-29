package com.goinhn.thorwcode.leetcode.question._1401_1500;

/**
 * 1470.重新排列数组
 *
 * @author goinhn
 * @date 2022/8/29
 */
public class Sol1470 {

    /**
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {
        public int[] shuffle(int[] nums, int n) {
            int[] res = new int[nums.length];
            int left = 0;
            int right = n;
            int idx = 0;
            while (idx < res.length) {
                res[idx++] = nums[left++];
                res[idx++] = nums[right++];
            }

            return res;
        }
    }

    /**
     * 用多余的高位来存储排好序之后的数字，最后将高位的数字回正即可
     * time:O(n)
     * space:O(1)
     */
    private static class Solution2 {
        public int[] shuffle(int[] nums, int n) {
            for (int i = 0; i < nums.length; i++) {
                int j = i < n ? i * 2 : (i - n) * 2 + 1;
                nums[j] |= (nums[i] & 1023) << 10;
            }

            for (int i = 0; i < nums.length; i++) {
                nums[i] >>= 10;
            }

            return nums;
        }
    }

}
