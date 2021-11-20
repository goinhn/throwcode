package com.goinhn.thorwcode.leetcode.question._1_100;

/**
 * 内部直接循环调用
 */
public class Solution11_1 {

    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        int max = 0;

        for (int left = 0; left < height.length; left++) {
            for (int right = left + 1; right < height.length; right++) {
                int length = right - left;
                int area = height[left] < height[right] ? height[left] * length : height[right] * length;
                max = max > area ? max : area;
            }
        }

        return max;
    }

}
