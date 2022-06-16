package com.goinhn.throwcode.codinginterviews.simulation;

import java.util.Stack;

/**
 * 31.栈的压入、弹出序列
 *
 * @author goinhn
 * @date 2022/6/16
 */
public class Jz31 {

    /**
     * 利用栈来进行模拟
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {

        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> stack = new Stack<>();
            int pushI = 0;
            int popI = 0;
            while (popI < popped.length && (pushI < pushed.length || !stack.isEmpty())) {
                if (pushI < pushed.length && !stack.isEmpty()) {
                    if (stack.peek() == popped[popI]) {
                        stack.pop();
                        popI++;
                    } else if (pushed[pushI] == popped[popI]) {
                        pushI++;
                        popI++;
                    } else {
                        stack.push(pushed[pushI++]);
                    }

                } else if (pushI < pushed.length) {
                    if (pushed[pushI] == popped[popI]) {
                        pushI++;
                        popI++;
                    } else {
                        stack.push(pushed[pushI++]);
                    }

                } else {
                    if (stack.peek() == popped[popI]) {
                        stack.pop();
                        popI++;
                    } else {
                        return false;
                    }
                }
            }

            return true;
        }

    }

    /**
     * 利用栈来进行模拟
     * time:O(n)
     * space:O(n)
     */
    private static class Solution2 {

        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> stack = new Stack<>();
            int popI = 0;
            for (int pushNum : pushed) {
                stack.push(pushNum);
                while (!stack.isEmpty() && stack.peek() == popped[popI]) {
                    stack.pop();
                    popI++;
                }
            }

            return stack.isEmpty();
        }

    }

}
