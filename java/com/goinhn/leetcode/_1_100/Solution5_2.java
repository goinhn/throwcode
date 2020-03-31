package com.goinhn.leetcode._1_100;

import netscape.javascript.JSUtil;

// 反转字符串进行判断相同的最长子串，最后判断位置是否一致//超出时间限制
public class Solution5_2 {

    public static void main(String[] args) {
        String test = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        System.out.println(new Solution5_2().longestPalindrome(test));
    }

    public String longestPalindrome(String s) {
        if(s.equals("") || s == null) {
            return "";
        }
        String reverseS = new StringBuffer(s).reverse().toString();
        int[] result = new int[]{0, 0};

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < reverseS.length(); j++) {
                if (s.charAt(i) == reverseS.charAt(j)) {
                    result = theLongNum(s, reverseS, i, j, result[0], result[1]);
                } else {
                    continue;
                }
            }
        }
        return s.substring(result[0], result[1] + 1);
    }

    public int[] theLongNum(String s, String reverseS, int begin, int beginReverse, int left, int right) {
        int indexBegin = begin + 1;
        int indexBeginReverse = beginReverse + 1;

        while (indexBegin < s.length() && indexBeginReverse < reverseS.length()) {
            if (s.charAt(indexBegin) == reverseS.charAt(indexBeginReverse)) {
                if (s.length() - begin - 1 == indexBeginReverse && indexBegin - begin > right - left) {
                    left = begin;
                    right = indexBegin;
                }
            } else {
                break;
            }
            indexBegin++;
            indexBeginReverse++;
        }
        return new int[]{left, right};
    }

}
