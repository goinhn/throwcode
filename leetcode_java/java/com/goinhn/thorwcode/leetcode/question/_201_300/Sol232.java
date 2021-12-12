package com.goinhn.thorwcode.leetcode.question._201_300;

import java.util.Stack;

/**
 * 232.用队列实现栈
 *
 * @author goinhn
 * @date 2021/12/12
 */
public class Sol232 {

    private static class Solution1 {
        class MyQueue {
            public Stack<Integer> inputStack;
            public Stack<Integer> outputStack;

            public MyQueue() {
                inputStack = new Stack<>();
                outputStack = new Stack<>();
            }

            public void push(int x) {
                inputStack.push(x);
            }

            public int pop() {
                if (outputStack.isEmpty()) {
                    while (!inputStack.isEmpty()) {
                        outputStack.push(inputStack.pop());
                    }
                }

                return outputStack.pop();
            }

            public int peek() {
                if (outputStack.isEmpty()) {
                    while (!inputStack.isEmpty()) {
                        outputStack.push(inputStack.pop());
                    }
                }

                return outputStack.peek();
            }

            public boolean empty() {
                return inputStack.isEmpty() && outputStack.isEmpty();
            }
        }
    }
}
