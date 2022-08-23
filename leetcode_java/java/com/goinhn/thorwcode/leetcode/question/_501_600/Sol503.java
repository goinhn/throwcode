package com.goinhn.thorwcode.leetcode.question._501_600;

import java.util.Arrays;
import java.util.Stack;

/**
 * 503.下一个更大元素II
 *
 * @author goinhn
 * @date 2022/8/23
 */
public class Sol503 {

    /**
     * 单调栈
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {

        public int[] nextGreaterElements(int[] nums) {
            int len = nums.length;
            int[] res = new int[nums.length];
            Arrays.fill(res, -1);
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < len * 2 -1; i++) {
                while(!stack.isEmpty() && nums[stack.peek()] < nums[i % len]) {
                    res[stack.pop()] = nums[i % len];
                }
                stack.push(i % len);
            }

            return res;
        }

    }

}
