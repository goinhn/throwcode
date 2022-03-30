package com.goinhn.throwcode.codinginterviews.stack_list;

import java.util.Stack;

/**
 * <p>
 * 20.包含min函数的栈
 *
 * @author goinhn
 * @date 2020-12-09T20:23:08
 */
public class Jz30 {

    private static class Solution1 {

        private static class MinStack {

            private final Stack<Integer> stack;
            private final Stack<Integer> stackMin;

            public MinStack() {
                stack = new Stack<>();
                stackMin = new Stack<>();
            }

            public void push(int x) {
                if (stackMin.isEmpty() || x <= stackMin.peek()) {
                    stackMin.push(x);
                }
                stack.push(x);
            }

            public void pop() {
                if (stack.isEmpty()) {
                    return;
                }
                if (stack.peek().equals(stackMin.peek())) {
                    stackMin.pop();
                }
                stack.pop();
            }

            public int top() {
                if (stack.isEmpty()) {
                    return -1;
                }
                return stack.peek();
            }

            public int min() {
                if (stackMin.isEmpty()) {
                    return -1;
                }
                return stackMin.peek();
            }
        }
    }
}
