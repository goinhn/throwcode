package com.goinhn.thorwcode.leetcode.question._1101_1200;

/**
 * 1137.第N个泰波那契数列
 *
 * @author goinhn
 * @date 2023/1/2
 */
public class Sol1137 {

    /**
     * 迭代动态规划
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {
        public int tribonacci(int n) {
            if (n < 1) return 0;
            if (n < 3) return 1;

            int i0 = 0;
            int i1 = 1;
            int i2 = 1;
            int i3;
            for (int i = 2; i < n; i++) {
                i3 = i0 + i1 + i2;
                i0 = i1;
                i1 = i2;
                i2 = i3;
            }
            return i2;
        }
    }

    /**
     * 增加缓存
     * time:O(n)
     * space:O(n)
     */
    private static class Solution2 {
        private static int[] cache = new int[100];
        private static int flag = 2;

        static {
            cache[1] = 1;
            cache[2] = 1;
        }

        public int tribonacci(int n) {
            if (n < 1) return 0;
            if (n < 3) return 1;
            if (cache[n] != 0) {
                return cache[n];
            }
            for (int i = flag; i < n; i++) {
                cache[i + 1] = cache[i] + cache[i - 1] + cache[i - 2];
            }
            return cache[n];
        }
    }

}
