package com.goinhn.thorwcode.leetcode.question._1_100;

/**
 * 27.移除元素
 *
 * @author goinhn
 * @date 2021-11-06
 **/
public class Sol27 {

    /**
     * 双指针替换
     * 直接将重复的元素替换，无需移动
     * <p>
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {
        public int removeElement(int[] nums, int val) {
            int repeatIndex = nums.length;
            for (int i = 0; i < repeatIndex; i++) {
                if (nums[i] == val) {
                    nums[i] = nums[repeatIndex - 1];
                    repeatIndex--;
                    i--;
                }
            }

            return repeatIndex;
        }
    }

    /**
     * 双指针
     * <p>
     * time:O(n)
     * space:O(1)
     */
    private static class Solution2 {
        public int removeElement(int[] nums, int val) {
            int left = 0;
            for (int right = 0; right < nums.length; right++) {
                if (val != nums[right]) {
                    nums[left] = nums[right];
                    left++;
                }
            }
            return left;
        }
    }

}
