package com.goinhn.algorithm.datastructure.linertable.stack;

import java.util.Stack;

/**
 * <p>
 * leetcode 232
 * <p>
 * 使用栈实现队列的下列操作：
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 * <p>
 * 示例:
 * MyQueue queue = new MyQueue();
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 * <p>
 * 说明:
 * 你只能使用标准的栈操作 -- 也就是只有push to top,peek/pop from top,size, 和is empty操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 * </p>
 *
 * @author goinhn
 * @date 2020-09-12T20:58:38
 */
public class ImplementQueueUsingStacks {

    class MyQueue {
        // 入队栈
        public Stack<Integer> inputStack;
        // 出队栈
        public Stack<Integer> outputStack;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            inputStack = new Stack<>();
            outputStack = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            inputStack.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if(empty()) {
                return -1;
            }

            if (outputStack.isEmpty()) {
                while (!inputStack.isEmpty()) {
                    outputStack.push(inputStack.pop());
                }
            }

            return outputStack.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if(empty()) {
                return -1;
            }

            if (outputStack.isEmpty()) {
                while (!inputStack.isEmpty()) {
                    outputStack.push(inputStack.pop());
                }
            }

            return outputStack.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return inputStack.isEmpty() && outputStack.isEmpty();
        }
    }

}
