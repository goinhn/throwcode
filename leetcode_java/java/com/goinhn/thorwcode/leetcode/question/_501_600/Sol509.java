package com.goinhn.thorwcode.leetcode.question._501_600;

/**
 * 509.斐波那契数
 *
 * @author goinhn
 * @date 2023/1/2
 */
public class Sol509 {

    /**
     * 迭代动态规划
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {
        public int fib(int i) {
            if (i < 1) return 0;
            if (i < 2) return 1;

            int i0 = 0;
            int i1 = 1;
            for (int n = 1; n < i; n++) {
                int tmp = i0 + i1;
                i0 = i1;
                i1 = tmp;
            }
            return i1;
        }
    }

    /**
     * 增加缓存
     * time:O(n)
     * space:O(n)
     */
    private static class Solution2 {
        private static int[] cache = new int[100];
        private static int flag = 1;

        static {
            cache[1] = 1;
        }

        public int fib(int i) {
            if (i < 1) return 0;
            if (i < 2) return 1;
            if (cache[i] != 0) {
                return cache[i];
            }
            for (int n = flag; n < i; n++) {
                cache[n + 1] = cache[n] + cache[n - 1];
            }
            return cache[i];
        }
    }

}
