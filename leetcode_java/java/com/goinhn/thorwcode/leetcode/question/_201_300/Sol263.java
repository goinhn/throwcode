package com.goinhn.thorwcode.leetcode.question._201_300;

/**
 * @author goinhn
 * @date 2021/12/18
 */
public class Sol263 {

    private static class Solution1 {
        public boolean isUgly(int n) {
            if (n <= 0) {
                return false;
            }
            int[] factors = {2, 3, 5};
            for (int factor : factors) {
                while (n % factor == 0) {
                    n /= factor;
                }
            }
            return n == 1;
        }
    }
}
