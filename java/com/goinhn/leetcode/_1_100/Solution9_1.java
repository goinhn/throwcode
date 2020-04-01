package com.goinhn.leetcode._1_100;

/**
 * 反转进行判断
 */
public class Solution9_1 {

    public static void main(String[] args) {

    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int xTemp = x;
        int sum = 0;

        while (xTemp > 0) {
//            判断转换后的数组是否有越界
            if (sum > Integer.MAX_VALUE / 10 || sum == Integer.MAX_VALUE && xTemp % 10 > 7){
                return false;
            }

            sum = sum * 10 + xTemp % 10;
            xTemp /= 10;
        }

        if (sum == x) {
            return true;
        }

        return false;
    }

}
