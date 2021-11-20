package com.goinhn.thorwcode.leetcode.question.els.problem29;

public class Solution1 {
    public int divide(int dividend, int divisor) {
        boolean sign = (dividend > 0) ^ (divisor > 0);

        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }

        int quotient = 0;
        while(dividend <= divisor) {
            int tempQuotient = -1;
            int temp_divisor = divisor;
            while(dividend <= (temp_divisor << 1)) {
                if(temp_divisor <= (Integer.MIN_VALUE >> 1))break;
                tempQuotient = tempQuotient << 1;
                temp_divisor = temp_divisor << 1;
            }
            dividend = dividend - temp_divisor;
            quotient += tempQuotient;
        }

        if(!sign){
            if(quotient <= Integer.MIN_VALUE){
                return Integer.MAX_VALUE;
            }
            quotient = -quotient;
        }

        return quotient;
    }

    public static void main(String[] args) {
        int dividend = -2147483648;
        int divisor = -1;

        System.out.println(new com.goinhn.leetcode.Solution1().divide(dividend, divisor));
    }

}


