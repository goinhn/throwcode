package com.goinhn.thorwcode.leetcode.question._201_300;

/**
 * 283.移动零
 *
 * @author goinhn
 * @date 2022/7/1
 */
public class Sol283 {

    /**
     * 指针移动
     * <p>
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {

        public void moveZeroes(int[] nums) {
            int left = 0;
            int right = 0;
            while (right < nums.length) {
                if (nums[right] != 0) {
                    if (left < right) {
                        nums[left] = nums[right];
                    }
                    left++;
                }
                right++;
            }

            // 补齐剩下的0
            while (left < nums.length) {
                nums[left] = 0;
                left++;
            }
        }

    }

}
