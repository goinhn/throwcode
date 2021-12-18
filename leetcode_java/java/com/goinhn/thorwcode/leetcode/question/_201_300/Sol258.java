package com.goinhn.thorwcode.leetcode.question._201_300;

/**
 * 258.各位相加
 *
 * @author goinhn
 * @date 2021/12/15
 */
public class Sol258 {

    /**
     * 循环迭代
     */
    private static class Solution1 {
        public int addDigits(int num) {
            while (num > 9) {
                int temp = 0;
                while (num > 0) {
                    temp += num % 10;
                    num /= 10;
                }
                num = temp;
            }
            return num;
        }
    }

    /**
     * 数根运算
     */
    private static class Solution2 {
        public int addDigits(int num) {
            return (num - 1) % 9 + 1;
        }
    }
}
