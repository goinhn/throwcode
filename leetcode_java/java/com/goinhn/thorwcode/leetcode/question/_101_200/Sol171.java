package com.goinhn.thorwcode.leetcode.question._101_200;

/**
 * 171.Excel表列序号
 *
 * @author goinhn
 * @date 2021/11/30
 */
public class Sol171 {

    private static class Solution1 {
        public int titleToNumber(String columnTitle) {
            int bottomNum = 1;
            int result = 0;
            for (int i = columnTitle.length() - 1; i > -1; i--) {
                result += bottomNum * ((columnTitle.charAt(i) - 'A') + 1);
                bottomNum *= 26;
            }
            return result;
        }
    }
}
