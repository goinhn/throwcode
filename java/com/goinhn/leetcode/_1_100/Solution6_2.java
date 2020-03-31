package com.goinhn.leetcode._1_100;

public class Solution6_2 {

    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows == 2) {
            return s;
        }

        if (s == null || s.length() == 0) {
            return "";
        }

        int group = 2 * numRows - 2;
        String sTemp = s;
        String result = "";
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < sTemp.length(); j += group) {
                if (i == 0) {
                    result += sTemp.charAt(j);
                    continue;
                }
                if (j + i == j + group - i) {
                    if (j + i >= s.length()) {
                        break;
                    }
                    result += sTemp.charAt(i + j);
                    continue;
                }
                if (j + i >= s.length()) {
                    break;
                }
                result += sTemp.charAt(j + i);
                if (j + group - i >= s.length()) {
                    break;
                }
                result += sTemp.charAt(j + group - i);
            }
        }

        return result;
    }

}
