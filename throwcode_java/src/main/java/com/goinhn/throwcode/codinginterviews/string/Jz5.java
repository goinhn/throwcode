package com.goinhn.throwcode.codinginterviews.string;

/**
 * 5.替换空格
 *
 * @author goinhn
 * @date 2020-12-05T14:30:25
 */
public class Jz5 {

    private static class Solution1 {

        private static final String target = "%20";

        public String replaceSpace(String s) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    result.append(target);
                } else {
                    result.append(s.charAt(i));
                }
            }
            return result.toString();
        }
    }

    private static class Solution2 {

        private static final String target = "%20";

        public String replaceSpace(String s) {
            return s.replaceAll(" ", target);
        }
    }
}