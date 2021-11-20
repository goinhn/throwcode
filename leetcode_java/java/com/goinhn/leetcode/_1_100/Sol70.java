package com.goinhn.leetcode._1_100;

/**
 * 70.爬楼梯
 *
 * @author goinhn
 * @date 2021/11/20
 */
public class Sol70 {

    /**
     * 动态规划
     * <p>
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {
        public int climbStairs(int n) {
            if (n < 3) {
                return n;
            }

            int one = 1;
            int two = 2;
            int result = 0;
            for (int i = 0; i < n - 2; i++) {
                result = one + two;
                one = two;
                two = result;
            }

            return result;
        }
    }
}
