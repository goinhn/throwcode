package com.goinhn.algorithm.stringalg;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * 回文串相关的算法
 * <p>
 * 回文串
 * “回文串”是一个正读和反读都一样的字符串，比如“level”或者“noon”等等就是回文串。
 * </p>
 *
 * @author goinhn
 * @date 2020-12-02T21:59:16
 */
public class Palindrome {

    /**
     * 最长回文串
     * <p>
     * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
     * 在构造过程中，请注意区分大小写。比如"Aa"不能当做一个回文字符串。注 意:假设字符串的长度不会超过 1010。
     */
    public static class LongestPalindrome {
        public static int getLongestPalindrome(String str) {
            if (str == null || str.length() == 0) {
                return 0;
            }

            Set<Character> set = new HashSet<>();
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                if (set.contains(str.charAt(i))) {
                    count++;
                    set.remove(str.charAt(i));
                } else {
                    set.add(str.charAt(i));
                }
            }

            return set.isEmpty() ? count * 2 : count * 2 + 1;
        }
    }


    /**
     * 验证是否为回文字符串
     * 只考虑字母和数字，字母忽略大小写，将空字符串定义为有效的回文字符串
     */
    public static class VerifyPalindrome {
        public static boolean verifyPalindrome(String str) {
            if (str == null) {
                return false;
            }

            if (str.length() == 0) {
                return true;
            }

            int l = 0, r = str.length() - 1;
            while (l < r) {
//                判断是否是字母或者数字
                if (!Character.isLetterOrDigit(str.charAt(l))) {
                    l++;
//                    判断是否是字母或者数字
                } else if (!Character.isLetterOrDigit(str.charAt(r))) {
                    r--;
                } else {
//                    统一转换为小写的字母
                    if (Character.toLowerCase(str.charAt(l)) != Character.toLowerCase(str.charAt(r))) {
                        return false;
                    }

                    l++;
                    r--;
                }
            }

            return true;
        }
    }


    /**
     * 最长回文子串
     * 最长回文子串 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
     */
    public static class LongestPalindromeSub {

        private static int index;
        private static int len;

        public static String longestPalindromeSub(String str) {
            if (str == null || str.length() < 2) {
                return str;
            }

            for (int i = 0; i < str.length(); i++) {
                palindromeHelper(str, i, i);
                palindromeHelper(str, i, i + 1);
            }

            return str.substring(index, index + len);
        }

        public static void palindromeHelper(String str, int l, int r) {
            while (l > -1 && r < str.length() && str.charAt(l) == str.charAt(r)) {
                l--;
                r++;
            }

            if (len < r - l - 1) {
                index = l + 1;
                len = r - l - 1;
            }
        }
    }


    /**
     * 最长回文子序列
     * 最长回文子序列和上一题最长回文子串的区别是，子串是字符串中连续的一个序列，而子序列是字符串中保持相对位置的字符序列，
     * 例如，"bbbb"可以是字符串"bbbab"的子序列但不是子串。
     */
    public static class LongestPalindromeSubSeq {

        /**
         * 递归
         * <p>
         * str[0...n-1]是给定的字符串序列，长度为n，假设lps(0,n-1)表示序列str[0...n-1]的最长回文子序列的长度。
         * <p>
         * 1.如果str的最后一个元素和第一个元素是相同的，则有：lps(0,n-1)=lps(1,n-2)+2；
         * 例如字符串序列“AABACACBA”，第一个元素和最后一个元素相同，其中lps(1,n-2)，表示红色部分的最长回文子序列的长度；
         * <p>
         * 2.如果str的最后一个元素和第一个元素是不相同的，则有：lps(0,n-1)=max(lps(1,n-1),lps(0,n-2))；
         * 例如字符串序列“ABACACB”，其中lps(1,n-1)，表示去掉第一元素的子序列，lps(0,n-2)表示去掉最后一个元素的子序列。
         *
         * @param str
         * @param l
         * @param r
         * @return
         */
        public static int longestPalindrome(String str, int l, int r) {
            if (l == r) {
                return 1;
            }

            if (l > r) {
                return 0;
            }

            if (str.charAt(l) == str.charAt(r)) {
                return longestPalindrome(str, l + 1, r - 1) + 2;
            } else {
                return Math.max(longestPalindrome(str, l, r - 1), longestPalindrome(str, l + 1, r));
            }
        }


        /**
         * 动态规划
         *
         * @param str
         * @return
         */
        public static int longestPalindrome(String str) {
            int len = str.length();
            int[][] dp = new int[len][len];
            for (int i = len - 1; i >= 0; i--) {
                dp[i][i] = 1;
                for (int j = i + 1; j < len; j++) {
                    if (str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }

            return dp[0][len - 1];
        }
    }
}
