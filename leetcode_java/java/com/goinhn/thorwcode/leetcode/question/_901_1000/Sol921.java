/*
 * Copyright NetEase, Inc. ALl rights reserved.
 */

package com.goinhn.thorwcode.leetcode.question._901_1000;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 921.使括号有效的最少添加
 *
 * @author fangwenzhan
 * @date 2022/10/4
 */
public class Sol921 {

    /**
     * 栈
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {

        public int minAddToMakeValid(String s) {
            Map<Character, Character> bracketMap = new HashMap<>();
            bracketMap.put(')', '(');

            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (stack.isEmpty()) {
                    stack.push(c);
                } else if (stack.peek().equals(bracketMap.get(c))) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

            return stack.size();
        }

    }

    /**
     * 贪心匹配
     * time:O(n)
     * space:O(1)
     */
    private static class Solution2 {

        public int minAddToMakeValid(String s) {
            int ans = 0;
            int leftCount = 0;
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    leftCount++;
                } else {
                    if (leftCount > 0) {
                        leftCount--;
                    } else {
                        ans++;
                    }
                }
            }

            ans += leftCount;
            return ans;
        }

    }


}
