package com.goinhn.thorwcode.leetcode.question._1_100;

/**
 * 5.最长回文串
 *
 * @author goinhn
 * @date 2022/7/14
 */
public class Sol5 {

    /**
     * 暴力法，双重循环
     * time:O(n^2)
     * space:O(1)
     */
    private static class Solution1 {

        public String longestPalindrome(String s) {
            if (s == null || s.isEmpty()) {
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
                            break;
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

    private static class Solution2 {
        public String longestPalindrome(String s) {
            if (s == null || s.isEmpty()) {
                return "";
            }

            String reS = new StringBuffer(s).reverse().toString();
            int[] index = new int[]{0, 0};
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < reS.length(); j++) {
                    if (s.charAt(i) == reS.charAt(j)) {
                        index = theLongNum(s, reS, i, j, index[0], index[1]);
                    }
                }
            }

            return s.substring(index[0], index[1] + 1);
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

    private static class Solution3 {
        public String longestPalindrome(String s) {
            if (s == null || s.isEmpty()) return "";
            int start = 0, end = 0;
            for (int i = 0; i < s.length(); i++) {
                int len1 = expandAroundCenter(s, i, i);
                int len2 = expandAroundCenter(s, i, i + 1);
                int len = Math.max(len1, len2);
                if (len > end - start) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }
            return s.substring(start, end + 1);
        }

        private int expandAroundCenter(String s, int left, int right) {
            int L = left, R = right;
            while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
                L--;
                R++;
            }
            return R - L - 1;
        }
    }
}
