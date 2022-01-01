package com.goinhn.throwcode.codinginterviews.dynamic_programming;

/**
 * 10II.青蛙跳台阶问题
 *
 * @author goinhn
 * @date 2020-12-04T14:06:17
 */
public class Jz10II {

    /**
     * 递归
     * time:O(nlogn)
     * space:O(nlogn)
     */
    private static class Solution1 {

        private static final int MOD = (int) 1e9 + 7;

        public int numWays(int n) {
            if (n <= 0) {
                return 1;
            }
            if (n <= 2) {
                return n;
            }
            return numWays(n - 1) + numWays(n - 2);
        }
    }

    /**
     * 迭代、动态规划
     * time:O(n)
     * space:O(1)
     */
    private static class Solution2 {
        private static final int MOD = (int) 1e9 + 7;

        public int numWays(int n) {
            if (n <= 0) {
                return 1;
            }
            if (n <= 2) {
                return n;
            }

            int first = 1;
            int second = 2;
            int third = 0;
            for (int i = 3; i < n + 1; i++) {
                third = (first + second) % MOD;
                first = second;
                second = third;
            }
            return third;
        }
    }
}
