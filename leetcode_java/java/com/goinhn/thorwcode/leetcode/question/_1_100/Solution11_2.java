package com.goinhn.thorwcode.leetcode.question._1_100;

public class Solution11_2 {

    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        if (height == null || height.length == 0 || height.length == 1) {
            return 0;
        }

        if (height.length == 2) {
            return height[0] < height[1] ? height[0] : height[1];
        }

        int begin = 0;
        int end = height.length - 1;
        int length = end;
        int maxSize = height[begin] < height[end] ? height[begin] * length : height[end] * length;

        while (length > 0) {
            if (height[begin] > height[end]) {
                end--;
                length--;
                int nowSize = height[begin] < height[end] ? height[begin] * length : height[end] * length;
                maxSize = maxSize > nowSize ? maxSize : nowSize;
            } else {
                begin++;
                length--;
                int nowSize = height[begin] < height[end] ? height[begin] * length : height[end] * length;
                maxSize = maxSize > nowSize ? maxSize : nowSize;
            }
        }

        return maxSize;
    }

}
