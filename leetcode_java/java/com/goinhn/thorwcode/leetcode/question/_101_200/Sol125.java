package com.goinhn.thorwcode.leetcode.question._101_200;

/**
 * 125.验证回文串
 *
 * @author goinhn
 * @date 2021/11/24
 */
public class Sol125 {

    /**
     * 双指针
     * <p>
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {
        public boolean isPalindrome(String s) {
            String lowerS = s.toLowerCase();
            int left = 0;
            int right = lowerS.length() - 1;
            while (left < right) {
                if (!Character.isLetterOrDigit(lowerS.charAt(left))) {
                    left++;
                    continue;
                }
                if (!Character.isLetterOrDigit(lowerS.charAt(right))) {
                    right--;
                    continue;
                }
                if (lowerS.charAt(left) != lowerS.charAt(right)) {
                    return false;
                } else {
                    left++;
                    right--;
                }
            }
            return true;
        }
    }

    /**
     * 正则匹配非数字和字母去除
     * <p>
     * time:O(n)
     * space:O(1)
     */
    private static class Solution2 {
        public boolean isPalindrome(String s) {
            s = s.replaceAll("[^a-zA-Z0-9]", "");
            System.out.println(s);
            String lowerS = s.toLowerCase();
            for (int left = 0, right = lowerS.length() - 1; left < right; left++, right--) {
                if (lowerS.charAt(left) != lowerS.charAt(right)) {
                    return false;
                }
            }
            return true;
        }
    }
}
