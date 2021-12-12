package com.goinhn.thorwcode.leetcode.question._201_300;

/**
 * 231.2的幂
 *
 * @author goinhn
 * @date 2021/12/12
 */
public class Sol231 {

    /**
     * 位操作
     * time:O(1)
     * space:O(1)
     */
    private static class Solution1 {
        public boolean isPowerOfTwo(int n) {
            return n > 0 && (n & (n - 1)) == 0;
        }
    }

    /**
     * 最大约数
     * time:O(1)
     * space:O(1)
     */
    private static class Solution2 {
        private static final Integer MAX_2 = 1 << 30;

        public boolean isPowerOfTwo(int n) {
            return n > 0 && MAX_2 % n == 0;
        }
    }
}
