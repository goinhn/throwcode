package com.goinhn.algorithm.datastructure.linertable.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 * leetcode 225
 * <p>
 * 使用队列实现栈的下列操作：
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * <p>
 * 注意:
 * 你只能使用队列的基本操作-- 也就是push to back, peek/pop from front, size, 和is empty这些操作是合法的。
 * 你所使用的语言也许不支持队列。你可以使用 list 或者 deque（双端队列）来模拟一个队列, 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 * </p>
 *
 * @author goinhn
 * @date 2020-09-13T00:13:57
 */
public class ImplementStackUsingQueues {

    /**
     * 双队列来实现
     */
    class MyStackDoubleQueue {

        public Queue<Integer> queue1;
        public Queue<Integer> queue2;

        /**
         * Initialize your data structure here.
         */
        public MyStackDoubleQueue() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            if (queue1.isEmpty()) {
                queue2.add(x);
            } else {
                queue1.add(x);
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
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

        /**
         * Get the top element.
         */
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

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue1.isEmpty() && queue2.isEmpty();
        }
    }


    /**
     * 单个队列来实现
     */
    class MyStackSingleQueue {

        public Queue<Integer> queue;

        /**
         * Initialize your data structure here.
         */
        public MyStackSingleQueue() {
            queue = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            queue.add(x);
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            if (empty()) {
                return -1;
            }

            int size = queue.size();
            while (size > 1) {
                queue.add(queue.remove());
                size--;
            }

            return queue.remove();
        }

        /**
         * Get the top element.
         */
        public int top() {
            if (empty()) {
                return -1;
            }

            int size = queue.size();
            while (size > 1) {
                queue.add(queue.remove());
                size--;
            }

            int result = queue.remove();
            queue.add(result);

            return result;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

}
