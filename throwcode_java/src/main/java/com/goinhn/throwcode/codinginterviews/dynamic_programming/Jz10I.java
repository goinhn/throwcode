package com.goinhn.throwcode.codinginterviews.dynamic_programming;

/**
 * 10I.斐波那契数列
 *
 * @author goinhn
 * @date 2020-12-04T12:15:42
 */
public class Jz10I {

    /**
     * 递归
     * time:O(nlogn)
     * space:O(nlogn)
     */
    private static class Solution1 {
        public int fib(int n) {
            if (n <= 1) {
                return n;
            }

            return fib(n - 1) + fib(n - 2);
        }
    }

    /**
     * 迭代、动态规划
     * time:O(n)
     * space:O(1)
     */
    private static class Solution2 {
        private static final int MOD_NUM = (int) 1e9 + 7;

        public int fib(int n) {
            if (n <= 1) {
                return n;
            }

            int first = 0;
            int second = 1;
            int third = 0;
            for (int i = 2; i < n + 1; i++) {
                third = (first + second) % MOD_NUM;
                first = second;
                second = third;
            }

            return third;
        }
    }

    /**
     * 矩阵快速求幂
     * time:(logn)
     * space:(1)
     */
    private static class Solution3 {
        private static final int MOD = (int) 1e9 + 7;

        private long[][] mul(long[][] a, long[][] b) {
            int r = a.length, c = b[0].length, z = b.length;
            long[][] ans = new long[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    for (int k = 0; k < z; k++) {
                        ans[i][j] += a[i][k] * b[k][j];
                        ans[i][j] %= MOD;
                    }
                }
            }
            return ans;
        }

        public int fib(int n) {
            if (n <= 1) {
                return n;
            }
            long[][] mat = new long[][]{
                    {1, 1},
                    {1, 0}
            };
            long[][] ans = new long[][]{
                    {1},
                    {0}
            };
            int x = n - 1;
            while (x != 0) {
                if ((x & 1) != 0) {
                    ans = mul(mat, ans);
                }
                mat = mul(mat, mat);
                x >>= 1;
            }
            return (int) (ans[0][0] % MOD);
        }
    }
}
