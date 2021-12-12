package com.goinhn.thorwcode.leetcode.question._201_300;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225.用队列实现栈
 *
 * @author goinhn
 * @date 2021/12/12
 */
public class Sol225 {

    /**
     * 两个队列
     */
    private static class Solution1 {
        class MyStack {

            public Queue<Integer> queue1;
            public Queue<Integer> queue2;

            public MyStack() {
                queue1 = new LinkedList<>();
                queue2 = new LinkedList<>();
            }

            public void push(int x) {
                if (queue1.isEmpty()) {
                    queue2.add(x);
                } else {
                    queue1.add(x);
                }
            }

            public int pop() {
                if (queue1.isEmpty()) {
                    while (queue2.size() > 1) {
                        queue1.add(queue2.remove());
                    }
                    return queue2.remove();
                } else {
                    while (queue1.size() > 1) {
                        queue2.add(queue1.remove());
                    }
                    return queue1.remove();
                }
            }

            public int top() {
                if (queue1.isEmpty()) {
                    while (queue2.size() > 1) {
                        queue1.add(queue2.remove());
                    }
                    int temp = queue2.remove();
                    queue1.add(temp);
                    return temp;
                } else {
                    while (queue1.size() > 1) {
                        queue2.add(queue1.remove());
                    }
                    int temp = queue1.remove();
                    queue2.add(temp);
                    return temp;
                }
            }

            public boolean empty() {
                return queue1.isEmpty() && queue2.isEmpty();
            }
        }
    }

    /**
     * 一个队列
     */
    private static class Solution2 {
        class MyStack {
            public Queue<Integer> queue;

            public MyStack() {
                queue = new LinkedList<>();
            }

            public void push(int x) {
                queue.add(x);
                int size = queue.size();
                while (size > 1) {
                    queue.add(queue.remove());
                    size--;
                }
            }

            public int pop() {
                return queue.remove();
            }

            public int top() {
                return queue.peek();
            }

            public boolean empty() {
                return queue.isEmpty();
            }
        }
    }
}
