package com.goinhn.leetcode._1_100;

/**
 * 67.二进制求和
 *
 * @author goinhn
 * @date 2021-11-16
 **/
public class Sol67 {

    /**
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {
        public String addBinary(String a, String b) {
            StringBuilder res = new StringBuilder();
            int length = Math.max(a.length(), b.length());
            int carry = 0;
            for (int i = 0; i < length; i++) {
                carry += (i < a.length()) ? (a.charAt(a.length() - 1 - i) - '0') : 0;
                carry += (i < b.length()) ? (b.charAt(b.length() - 1 - i) - '0') : 0;
                res.append(carry % 2);
                carry /= 2;
            }
            if (carry > 0) {
                res.append(carry);
            }
            return res.reverse().toString();
        }
    }
}
