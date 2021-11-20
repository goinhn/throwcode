package com.goinhn.algorithm.datastructure.linertable.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


/**
 * <p>
 * leetcode 20
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * <p>
 * 示例2:
 * 输入: "()[]{}"
 * 输出: true
 * <p>
 * 示例3:
 * 输入: "(]"
 * 输出: false
 * <p>
 * 示例4:
 * 输入: "([)]"
 * 输出: false
 * <p>
 * 示例5:
 * 输入: "{[]}"
 * 输出: true
 * </p>
 *
 * @author goinhn
 * @date 2020-12-15T17:55:47
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char next = s.charAt(i);
            if (map.containsKey(next) && stack.size() != 0 && map.get(next).equals(stack.peek())) {
                stack.pop();
            } else {
                stack.push(next);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "}";
        System.out.println(new ValidParentheses().isValid(str));
    }
}