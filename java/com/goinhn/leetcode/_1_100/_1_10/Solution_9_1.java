package com.goinhn.leetcode._1_100._1_10;

/**
 * 反转重新生成一个整数进行判断
 * <p>
 * 空间复杂度:O(1)
 * 时间复杂度:O(n)
 */
public class Solution_9_1 {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }

    /**
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int xTemp = x;
        int sum = 0;

        while (xTemp > 0) {
//            判断转换后的数组是否有越界
            if (sum > Integer.MAX_VALUE / 10 || sum == Integer.MAX_VALUE && xTemp % 10 > 7) {
                return false;
            }

            sum = sum * 10 + xTemp % 10;
            xTemp /= 10;
        }

        return sum == x;
    }

}
