package com.goinhn.throwcode.codinginterviews.bit_operation;

/**
 * 65.不用加减乘除做加法
 *
 * @author goinhn
 * @date 2022/4/19
 */
public class Jz65 {

    /**
     * 在不考虑进位的情况下，1011+1001得到0110，1+1=0、1+0=1、0+0=0，正好符合异或运算；
     * 考虑进位时，1011+1001得到的是10010，只有相同位置都为1时才会有进位，正好符合位与运算再左移一位；
     * <p>
     * time:O(1)
     * space:O(1)
     */
    private static class Solution1 {
        public int add(int a, int b) {
            int sum = 0;
            int carry = 0;
            do {
                sum = a ^ b;
                carry = (a & b) << 1;
                a = sum;
                b = carry;
            } while (carry != 0);
            return sum;
        }
    }

    private static class Solution2 {
        public int add(int a, int b) {
            while (b != 0) {
                int sum = a ^ b;
                b = (a & b) << 1;
                a = sum;
            }
            return a;
        }
    }

}
