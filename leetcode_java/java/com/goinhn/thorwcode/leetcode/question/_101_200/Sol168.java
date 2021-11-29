package com.goinhn.thorwcode.leetcode.question._101_200;

/**
 * @author goinhn
 * @date 2021/11/29
 */
public class Sol168 {

    /**
     * time:O(log26(n))
     * space:O(1)
     */
    private static class Solution1 {
        public String convertToTitle(int columnNumber) {
            StringBuilder result = new StringBuilder();
            while (columnNumber > 0) {
                columnNumber--;
                result.insert(0, (char) ('A' + columnNumber % 26));
                columnNumber /= 26;
            }
            return result.toString();
        }
    }
}
