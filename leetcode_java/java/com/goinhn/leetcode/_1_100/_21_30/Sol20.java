package com.goinhn.leetcode._1_100._21_30;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20.有效的括号
 * <p>
 * 空间复杂度:O(n+∣Σ∣)
 * 时间复杂度:O(n)
 *
 * @author goinhn
 * @date 2020-09-13
 */
public class Sol20 {

    /**
     * 利用栈和哈希匹配
     *
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {

        private static final Map<Character, Character> BRACKET_MAP = new HashMap<>();

        private static void initBracketMap() {
            BRACKET_MAP.put(')', '(');
            BRACKET_MAP.put(']', '[');
            BRACKET_MAP.put('}', '{');
        }

        public Solution1() {
            initBracketMap();
        }

        public static boolean isValid(String s) {
            char[] brackets = s.toCharArray();
            Stack<Character> stack = new Stack<>();

            for (char bracket : brackets) {
                if (!BRACKET_MAP.containsKey(bracket)) {
                    stack.add(bracket);
                } else if (BRACKET_MAP.containsKey(bracket)
                        && !stack.isEmpty()
                        && BRACKET_MAP.get(bracket).equals(stack.peek())) {
                    stack.pop();
                } else {
                    return false;
                }
            }

            return stack.isEmpty();
        }
    }
}
