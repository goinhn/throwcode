package com.goinhn.leetcode._1_100._21_30;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * <p>
 * 空间复杂度:O(n+∣Σ∣)
 * 时间复杂度:O(n)
 * </p>
 *
 * @author goinhn
 * @date 2020-09-13T00:44:00
 */
public class Solution_20_1 {

    /**
     * 利用栈和哈希匹配
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        char[] brackets = s.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();

        for (char bracket : brackets) {
            if (!map.containsKey(bracket)) {
                stack.add(bracket);
            } else if (map.containsKey(bracket) && !stack.isEmpty() && map.get(bracket) == stack.peek()) {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
    }

}
