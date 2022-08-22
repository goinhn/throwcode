package com.goinhn.thorwcode.leetcode.question._401_500;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 496.下一个更大元素I
 *
 * @author goinhn
 * @date 2022/8/22
 */
public class Sol496 {

    /**
     * 遍历
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {

        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int[] res = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                boolean isNum = false;
                boolean isMax = false;
                for (int num2 : nums2) {
                    if (num2 == nums1[i]) {
                        isNum = true;
                    }

                    if (isNum && num2 > nums1[i]) {
                        res[i] = num2;
                        isMax = true;
                        break;
                    }
                }

                if (!isMax) {
                    res[i] = -1;
                }
            }

            return res;
        }

    }

    /**
     * 单调栈
     * time:O(n)
     * space:O(1)
     */
    private static class Solution2 {

        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Map<Integer, Integer> map = new HashMap<>();
            Stack<Integer> stack = new Stack<>();
            for (int i = nums2.length - 1; i > -1; i--) {
                while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                    stack.pop();
                }
                map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
                stack.push(nums2[i]);
            }

            int[] res = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                res[i] = map.get(nums1[i]);
            }

            return res;
        }

    }

}
