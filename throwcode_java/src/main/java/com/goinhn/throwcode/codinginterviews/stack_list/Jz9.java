package com.goinhn.throwcode.codinginterviews.stack_list;

import java.util.Stack;

/**
 * 5.用两个栈实现队列
 *
 * @author goinhn
 * @date 2020-12-08T12:02:36
 */
public class Jz9 {

    private static class Solution1 {
        public static class CQueue {

            private final Stack<Integer> stackPush;
            private final Stack<Integer> stackPop;

            public CQueue() {
                stackPush = new Stack<>();
                stackPop = new Stack<>();
            }

            public void appendTail(int value) {
                stackPush.push(value);
            }

            public int deleteHead() {
                int result = -1;
                if (stackPop.isEmpty()) {
                    while (!stackPush.isEmpty()) {
                        stackPop.push(stackPush.pop());
                    }
                }

                if (!stackPop.isEmpty()) {
                    result = stackPop.pop();
                }
                return result;
            }
        }
    }
}
