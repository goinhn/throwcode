package com.goinhn.thorwcode.leetcode.question._1_100;

/**
 * 7. 整数反转
 *
 * @author goinhn
 * @date 2021-11-03
 */
public class Sol7 {

    /**
     * 通过逐位取数字来进行反转计算
     * Integer.MIN_VALUE = -2147483648
     * Integer.MAX_VALUE = 2147483647
     * <p>
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {
        public int reverse(int x) {
            int rev = 0;
            while (x != 0) {
                int pop = x % 10;
                x /= 10;
                // 在边界值的时候注意数字的大小
                if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                    return 0;
                }
                if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                    return 0;
                }
                rev = rev * 10 + pop;
            }
            return rev;
        }
    }

}
