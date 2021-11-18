package com.goinhn.leetcode._1_100;

/**
 * 14.最长公共前缀
 *
 * @author goinhn
 * @date 2021-11-04
 **/
public class Sol14 {

    /**
     * 循环匹配最长前缀
     * <p>
     * 字符串平均长度:m,字符串个数:n
     * time:O(mn)
     * space:O(1)
     */
    private static class Solution1 {
        public String longestCommonPrefix(String[] strs) {
            if (null == strs || 0 == strs.length) {
                return "";
            }
            if (1 == strs.length) {
                return strs[0];
            }

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < strs[0].length(); i++) {
                result.append(strs[0].charAt(i));
                for (int j = 1; j < strs.length; j++) {
                    if (i >= strs[j].length() || !result.toString().equals(strs[j].substring(0, i + 1))) {
                        return result.substring(0, result.length() - 1);
                    }
                }
            }
            return result.toString();
        }
    }

    /**
     * 循环匹配最长前缀
     * <p>
     * 字符串平均长度:m,字符串个数:n
     * time:O(mn)
     * space:O(1)
     */
    private static class Solution2 {
        public String longestCommonPrefix(String[] strs) {
            if (0 == strs.length) {
                return "";
            }

            String prefix = strs[0];
            for (int i = 1; i < strs.length; i++) {
                while (strs[i].indexOf(prefix) != 0) {
                    prefix = prefix.substring(0, prefix.length() - 1);
                    if (prefix.isEmpty()) {
                        return "";
                    }
                }
            }
            return prefix;
        }
    }

    /**
     * 纵向扫描
     * <p>
     * 字符串平均长度:m,字符串个数:n
     * time:O(mn)
     * space:O(1)
     */
    private static class Solution3 {
        public String longestCommonPrefix(String[] strs) {
            if (0 == strs.length) {
                return "";
            }

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < strs[0].length(); i++) {
                result.append(strs[0].charAt(i));
                for (int j = 0; j < strs.length - 1; j++) {
                    if (strs[j].charAt(i) != strs[j + 1].charAt(i)) {
                        return result.substring(0, result.length() - 1);
                    }
                }
            }
            return result.toString();
        }

        public static void main(String[] args) {
            String[] strs = {"flower", "flow", "flight"};
            System.out.println(new Solution3().longestCommonPrefix(strs));
        }
    }

    /**
     * 分治法
     * <p>
     * 字符串平均长度:m,字符串个数:n
     * time:O(mm)
     * space:O(mlogn)
     */
    private static class Solution4 {
        public String longestCommonPrefix(String[] strs) {
            if (null == strs || 0 == strs.length) {
                return "";
            }

            return commonPrefix(strs, 0, strs.length - 1);
        }

        /**
         * 分治递归
         */
        private String commonPrefix(String[] strs, int left, int right) {
            if (left >= right - 1) {
                return commonPrefixTwo(strs[left], strs[right]);
            }

            int middle = (left + right) / 2;
            String leftPrefix = commonPrefix(strs, left, middle);
            String rightPrefix = commonPrefix(strs, middle + 1, right);
            return commonPrefixTwo(leftPrefix, rightPrefix);
        }

        private String commonPrefixTwo(String leftPrefix, String rightPrefix) {
            if (leftPrefix.equals(rightPrefix)) {
                return leftPrefix;
            }

            String result = "";
            for (int i = 0; i < leftPrefix.length(); i++) {
                result = leftPrefix.substring(0, i + 1);
                if (0 != rightPrefix.indexOf(result)) {
                    return result.substring(0, result.length() - 1);
                }
            }
            return result;
        }
    }

    /**
     * 二分查找
     * <p>
     * 字符串平均长度:m,字符串个数:n
     * time:O(nlogm)
     * space:O(1)
     */
    private static class Solution5 {
        public String longestCommonPrefix(String[] strs) {
            if (null == strs || 0 == strs.length) {
                return "";
            }
            if (1 == strs.length) {
                return strs[0];
            }

            return getBinaryPrefix(strs);
        }

        private String getBinaryPrefix(String[] strs) {
            int left = 0;
            int right = strs[0].length();
            String result = "";
            String binaryPrefix = "";
            while (left <= right) {
                int middle = (left + right) / 2;
                binaryPrefix = strs[0].substring(0, middle);
                if (isCorrectPrefix(strs, binaryPrefix)) {
                    left = middle + 1;
                    result = binaryPrefix;
                } else {
                    right = middle - 1;
                }
            }

            return result;
        }

        private boolean isCorrectPrefix(String[] strs, String binaryPrefix) {
            for (int i = 1; i < strs.length; i++) {
                if (binaryPrefix.length() > strs[i].length() || 0 != strs[i].indexOf(binaryPrefix)) {
                    return false;
                }
            }
            return true;
        }
    }
}
