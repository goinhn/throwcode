package com.goinhn.leetcode._1_100._1_10;

/**
 * 7. 回文数
 *
 * @author goinhn
 * @date 2021-11-03
 */
public class Sol9 {

    /**
     * 反转重新生成一个整数进行判断
     * <p>
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }

            int xTemp = x;
            int sum = 0;
            while (xTemp > 0) {
                // 判断转换后的数组是否有越界
                if (sum > Integer.MAX_VALUE / 10 || (sum == Integer.MAX_VALUE / 10 && xTemp % 10 > 7)) {
                    return false;
                }
                sum = sum * 10 + xTemp % 10;
                xTemp /= 10;
            }

            return sum == x;
        }
    }

    /**
     * 将左半部分和右半部分进行比较是否相等
     * <p>
     * time:O(n)
     * space:O(1)
     */
    private static class Solution2 {
        public boolean isPalindrome(int x) {
            // 特殊情况：
            // 如上所述，当 x < 0 时，x 不是回文数。
            if (x < 0) {
                return false;
            }

            // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
            // 则其第一位数字也应该是 0
            // 只有 0 满足这一属性
            if (x % 10 == 0 && x != 0) {
                return false;
            }

            int revertedNumber = 0;
            while (x > revertedNumber) {
                revertedNumber = revertedNumber * 10 + x % 10;
                x /= 10;
            }

            // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
            // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
            // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
            return x == revertedNumber || x == revertedNumber / 10;
        }
    }


}
