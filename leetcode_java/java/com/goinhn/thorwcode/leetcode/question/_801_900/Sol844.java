package com.goinhn.thorwcode.leetcode.question._801_900;

import java.util.Stack;

/**
 * 844. 比较含退格的字符串
 *
 * @author goinhn
 * @date 2022/6/22
 */
public class Sol844 {

    /**
     * 利用栈返回清除退格键后的字符串
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {

        public boolean backspaceCompare(String s, String t) {
            s = build(s);
            t = build(t);

            return s.equals(t);
        }

        public String build(String str) {
            Stack<Character> stack = new Stack<>();
            for (char c : str.toCharArray()) {
                if (c != '#') {
                    stack.push(c);
                } else if (!stack.isEmpty()) {
                    stack.pop();
                }
            }

            return String.valueOf(stack);
        }

    }

    /**
     * 双指针从右往左进行遍历
     * time:O(n)
     * space:O(1)
     */
    private static class Solution2 {

        public boolean backspaceCompare(String s, String t) {
            int si = s.length() - 1;
            int ti = t.length() - 1;
            while (si > -1 || ti > -1) {
                si = backSpaceIndex(s, si);
                ti = backSpaceIndex(t, ti);

                if (si < 0 && ti >= 0
                        || ti < 0 && si >= 0) {
                    return false;
                }
                if (si < 0 && ti < 0) {
                    return true;
                }
                if (s.charAt(si) != t.charAt(ti)) {
                    return false;
                }

                si--;
                ti--;
            }

            return si == ti;
        }

        private int backSpaceIndex(String x, int xi) {
            int backCount = 0;
            while (xi > -1 && (backCount > 0 || x.charAt(xi) == '#')) {
                if (x.charAt(xi) == '#') {
                    backCount++;
                } else {
                    backCount--;
                }

                xi--;
            }

            return xi;
        }

    }

}
