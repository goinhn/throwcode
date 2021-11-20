package com.goinhn.thorwcode.leetcode.question._1_100;

// 暴力法进行遍历//超出时间限制
public class Sol_5_1 {

    public static void main(String[] args) {

    }

    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }

        boolean flag = false;
        int begin = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    continue;
                }
                flag = true;
                for (int x = 1; x <= (j - i) / 2; x++) {
                    if (s.charAt(i + x) != s.charAt(j - x)) {
                        flag = false;
                    }
                }
                if (flag && (j - i) > (end - begin)) {
                    begin = i;
                    end = j;
                }
            }
        }

        return s.substring(begin, end + 1);
    }

}
