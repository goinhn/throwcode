package com.goinhn.thorwcode.leetcode.question._1_100;

/**
 * 逐个字符进行判断
 */
public class Solution8_1 {

    public static void main(String[] args) {

    }

    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0 || str == null) {
            return 0;
        }

        int result = 0;
        int symbol = 1;
        int start = 0;

        if (str.charAt(0) == '+') {
            symbol = 1;
            start++;
        }
        if (str.charAt(0) == '-') {
            symbol = -1;
            start++;
        }

        for (int i = start; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return symbol * result;
            }

            int tempNumber = str.charAt(i) - '0';
            if (symbol == 1 && (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && tempNumber > 7)) {
                return Integer.MAX_VALUE;
            }
            if (symbol == -1 && (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && tempNumber > 8)) {
                return Integer.MIN_VALUE;
            }

            result = result * 10 + tempNumber;
        }

        return result * symbol;
    }

}
