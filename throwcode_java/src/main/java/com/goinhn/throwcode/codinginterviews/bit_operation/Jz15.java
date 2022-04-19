package com.goinhn.throwcode.codinginterviews.bit_operation;

/**
 * 15.二进制中1的个数
 *
 * @author goinhn
 * @date 2022/4/19
 */
public class Jz15 {

    /**
     * 循环校验
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {
        public int hammingWeight(int n) {
            int count = 0;
            int bitOne = 1;
            for (int i = 0; i < 32; i++) {
                if ((n & bitOne) != 0) {
                    count++;
                }
                bitOne <<= 1;
            }
            return count;
        }
    }

    /**
     * 利用n&(n - 1)会将最后一位的1变成0
     * time:O(n)
     * space:O(1)
     */
    private static class Solution2 {
        public int hammingWeight(int n) {
            int count = 0;
            while (n > 0) {
                n &= n - 1;
                count++;
            }
            return count;
        }
    }

}
