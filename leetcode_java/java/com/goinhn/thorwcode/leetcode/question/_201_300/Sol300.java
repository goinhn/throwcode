package com.goinhn.thorwcode.leetcode.question._201_300;

import java.util.Arrays;
import java.util.Stack;

/**
 * 300.最长递增子序列
 *
 * @author goinhn
 * @date 2024/4/20
 */
public class Sol300 {

    /**
     * 动态规划
     * time:O(n^2)
     * space:O(n)
     */
    private static class Solution1 {
        public int lengthOfLIS(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);
            int maxRes = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                maxRes = Math.max(maxRes, dp[i]);
            }

            return maxRes;
        }
    }

    /**
     * 单调栈
     * time:O(nlogn)
     * space:O(n)
     */
    private static class Solution2 {
        public int lengthOfLIS(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            Stack<Integer> stack = new Stack<>();
            stack.push(nums[0]);
            for (int i = 1; i < nums.length; i++) {
                if (stack.peek() < nums[i]) {
                    stack.push(nums[i]);
                } else if (stack.peek() < nums[i]) {
                    int idx = binaryFind(stack, nums[i]);
                    stack.set(idx, nums[i]);
                }
            }
            return stack.size();
        }

        private int binaryFind(Stack<Integer> arr, int target) {
            int l = 0;
            int r = arr.size() - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (arr.get(mid) > target) {
                    r = mid - 1;
                } else if (arr.get(mid) < target) {
                    l = mid + 1;
                } else {
                    return mid;
                }
            }
            if (arr.get(l) < target) {
                return l + 1;
            } else {
                return l;
            }
        }
    }

}
