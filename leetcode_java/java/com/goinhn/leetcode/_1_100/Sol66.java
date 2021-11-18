package com.goinhn.leetcode._1_100;

/**
 * 66.加一
 *
 * @author goinhn
 * @date 2021-11-15
 **/
public class Sol66 {

    /**
     * time:(n)
     * space:(1)
     */
    private static class Solution1 {
        public int[] plusOne(int[] digits) {
            int addOne = 1;
            for (int i = digits.length - 1; i > -1; i--) {
                int temp = addOne + digits[i];
                addOne = temp / 10;
                digits[i] = temp % 10;
                if (0 == addOne) {
                    break;
                }
                if (1 == addOne && 0 == i) {
                    int[] newDigits = new int[digits.length + 1];
                    newDigits[0] = 1;
                    return newDigits;
                }
            }
            return digits;
        }
    }
}
