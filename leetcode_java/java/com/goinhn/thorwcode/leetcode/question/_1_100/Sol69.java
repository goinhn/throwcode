package com.goinhn.thorwcode.leetcode.question._1_100;

/**
 * 69.Sqrt(x)
 *
 * @author goinhn
 * @date 2021-11-16
 **/
public class Sol69 {

    /**
     * 二分法
     * <p>
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {
        public int mySqrt(int x) {
            int left = 0;
            int right = x;
            int result = -1;
            while (left <= right) {
                int base = (left + right) >> 1;
                if ((long)base * base <= x) {
                    result = base;
                    left = base + 1;
                } else {
                    right = base - 1;
                }
            }
            return result;
        }
    }

}
