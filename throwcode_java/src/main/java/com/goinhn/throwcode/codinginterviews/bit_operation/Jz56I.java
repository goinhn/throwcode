package com.goinhn.throwcode.codinginterviews.bit_operation;

/**
 * 56I.数组中数字出现的次数
 *
 * @author goinhn
 * @date 2022/6/16
 */
public class Jz56I {

    /**
     * 位操作
     * <p>
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {

        public int[] singleNumbers(int[] nums) {
            // 找出两数的异或 (x ^ y)
            int allXor = 0;
            for (int num : nums) {
                allXor ^= num;
            }

            // 找出 (x ^ y) 首位为1的位置，主要是为了区分后续两个数组
            int firstOne = 1;
            while ((allXor & firstOne) == 0) {
                firstOne <<= 1;
            }

            // 划分为两个数组来进行获取两个不同数字
            int x = 0;
            int y = 0;
            for (int num : nums) {
                if ((firstOne & num) == 0) {
                    x ^= num;
                } else {
                    y ^= num;
                }
            }

            return new int[]{x, y};
        }

    }

}
