package com.goinhn.thorwcode.leetcode.question._101_200;

/**
 * 190.颠倒二进制位
 *
 * @author goinhn
 * @date 2021/12/5
 */
public class Sol190 {

    /**
     * 循环颠倒
     * <p>
     * time:O(1)
     * space:O(1)
     */
    private static class Solution1 {
        public int reverseBits(int n) {
            int result = 0;
            for (int i = 0; i < 32; i++) {
                result = (n & 1) << (31 - i);
                n >>>= 1;
            }
            return result;
        }
    }

    /**
     * 位运算分治
     * <p>
     * time:O(1)
     * space:o(1)
     */
    private static class Solution2 {
        private static final int M1 = 0b01010101010101010101010101010101;
        private static final int M2 = 0b00110011001100110011001100110011;
        private static final int M4 = 0b00001111000011110000111100001111;
        private static final int M8 = 0b00000000111111110000000011111111;

        public int reverseBits(int n) {
            n = n >>> 1 & M1 | (n & M1) << 1;
            n = n >>> 2 & M2 | (n & M2) << 2;
            n = n >>> 4 & M4 | (n & M4) << 4;
            n = n >>> 8 & M8 | (n & M8) << 8;
            return n >>> 16 | n << 16;
        }
    }
}
