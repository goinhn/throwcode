package com.goinhn.thorwcode.leetcode.question._1_100;

public class Solution10_1 {

    public static void main(String[] args) {

    }

    public boolean isMatch(String s, String p) {
        String dealStr = s;
        int flag = 0;
        for (int i = 1; i < dealStr.length(); i++) {
            if (dealStr.charAt(i) == dealStr.charAt(i - 1)) {
                flag++;
                continue;
            } else {
                if (flag > 0) {
                    dealStr = dealStr.replace(dealStr.charAt(i-1), '*');
                    for (int j = 1; j < flag; j++) {
                        dealStr = dealStr.replace(dealStr.charAt(i - j - 1), ' ');
                    }
                }
                flag = 0;
            }
        }
        dealStr = dealStr.replace(" ", "");

        return false;
    }

}
