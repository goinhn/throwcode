package com.goinhn.thorwcode.leetcode.question._201_300;

/**
 * 268.丢失的数字
 *
 * @author goinhn
 * @date 2023/4/5
 */
public class Sol268 {

    /**
     * 指针移动
     * <p>
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {

        public static void main(String[] args) {
            int[] nums = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
            new Solution1().missingNumber(nums);
        }

        public int missingNumber(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= nums.length) {
                    nums[i] = -1;
                } else if (nums[i] != -1) {
                    while (nums[i] != i && nums[i] != -1) {
                        if (nums[i] >= nums.length) {
                            nums[i] = -1;
                            break;
                        }
                        swap(nums, nums[i], i);
                    }
                }
            }

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == -1) {
                    return i;
                }
            }

            return nums.length;
        }

        private void swap(int[] nums, int l, int r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }
    }
}
