package com.goinhn.thorwcode.leetcode.question._1_100;

/**
 * 28.实现strStr()
 *
 * @author goinhn
 * @date 2021-11-06
 **/
public class Sol28 {

    /**
     * api
     */
    private static class Solution1 {
        public int strStr(String haystack, String needle) {
            return haystack.indexOf(needle);
        }
    }

    /**
     * 暴力匹配
     * haystack长度m，needle长度n
     * <p>
     * time:((m-n)n)
     * space:O(1)
     */
    private static class Solution2 {
        public int strStr(String haystack, String needle) {
            if (needle.length() > haystack.length()) {
                return -1;
            }

            int matchLength = haystack.length() - needle.length();
            for (int i = 0; i <= matchLength; i++) {
                boolean flag = true;
                for (int j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return i;
                }
            }

            return -1;
        }
    }

    /**
     * kmp匹配算法
     */
    private static class Solution3 {
        public int strStr(String haystack, String needle) {
            return 0;

        }
    }


}
