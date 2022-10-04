/*
 * Copyright NetEase, Inc. ALl rights reserved.
 */

package com.goinhn.thorwcode.leetcode.question._1_100;

/**
 * 11.盛最多水的容器
 *
 * @author fangwenzhan
 * @date 2022/10/4
 */
public class Sol11 {

    /**
     * 贪心算法
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {

        public int maxArea(int[] height) {
            int left = 0;
            int right = height.length - 1;
            int ans = Integer.MIN_VALUE;
            while (left < right) {
                int now = (right - left) * (Math.min(height[left], height[right]));
                ans = Math.max(now, ans);
                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }

            return ans;
        }

    }

}
