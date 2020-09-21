package com.goinhn.leetcode._1_100._1_10;

/**
 * 数字进行反转，逐个进行判断
 */
public class Solution7_1 {

    public static void main(String[] args) {

    }

    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            // 在边界值的时候注意数字的大小
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

}
