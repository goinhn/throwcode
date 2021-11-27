package com.goinhn.thorwcode.leetcode.question._101_200;

import java.util.Stack;

/**
 * 155.最小栈
 *
 * @author goinhn
 * @date 2021/11/27
 */
public class Sol155 {

    /**
     * 利用辅助栈存储每个最小值
     * <p>
     * time:O(1)
     * space:O(n)
     */
    private static class Solution1 {
        class MinStack {

            private Stack<Integer> storeStack;
            private Stack<Integer> minStack;

            public MinStack() {
                storeStack = new Stack<>();
                minStack = new Stack<>();
                minStack.push(Integer.MAX_VALUE);
            }

            public void push(int val) {
                storeStack.push(val);
                minStack.push(Math.min(minStack.peek(), val));
            }

            public void pop() {
                storeStack.pop();
                minStack.pop();
            }

            public int top() {
                return storeStack.peek();
            }

            public int getMin() {
                return minStack.peek();
            }
        }
    }
}
