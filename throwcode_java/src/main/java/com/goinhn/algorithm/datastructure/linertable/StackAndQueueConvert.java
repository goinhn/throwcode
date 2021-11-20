package com.goinhn.algorithm.datastructure.linertable;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * <p>
 * 栈和队列互相转换，仅用栈表示队列，仅用队列表示栈
 * </p>
 *
 * @author goinhn
 * @date 2020-08-26T20:21:23
 */
public class StackAndQueueConvert {

    /**
     * 用两个队列来进行模拟栈
     */
    public static class TwoQueueStack {

        private Queue<Integer> queue;
        // 辅助队列
        private Queue<Integer> help;

        public TwoQueueStack() {
            this.queue = new LinkedList<>();
            this.help = new LinkedList<>();
        }

        /**
         * 直接往queue中插入数据
         *
         * @param pushInt
         */
        public void push(int pushInt) {
            queue.add(pushInt);
        }

        /**
         * 查看栈顶的数据
         * 将数据往辅助队列中去倒
         *
         * @return
         */
        public int peek() {
            if (queue.isEmpty()) {
                throw new RuntimeException("Stack is empty!");
            }
            while (queue.size() > 1) {
                help.add(queue.poll());
            }
            int res = queue.poll();
            help.add(res);
            swap();
            return res;
        }

        /**
         * 将数据往辅助队列中去倒
         * 删除栈顶的元素
         *
         * @return
         */
        public int pop() {
            if (queue.isEmpty()) {
                throw new RuntimeException("Stack is empty!");
            }
            while (queue.size() > 1) {
                help.add(queue.poll());
            }
            int res = queue.poll();
            swap();
            return res;
        }

        private void swap() {
            Queue<Integer> tmp = help;
            help = queue;
            queue = tmp;
        }
    }

    /**
     * 用两个栈来模拟队列
     */
    public static class TwoStackQueue {

        private Stack<Integer> stack;
        private Stack<Integer> help;

        public TwoStackQueue() {
            this.stack = new Stack<>();
            this.help = new Stack<>();
        }

        public void push(int obj) {
            stack.push(obj);
        }

        public int pop() {
            if (stack.size() == 0) {
                throw new ArrayIndexOutOfBoundsException("the queue is empty");
            }
            while (stack.size() > 1) {
                help.push(stack.pop());
            }

            int res = stack.pop();
            swap();
            return res;
        }

        /**
         * 交换两个位置
         */
        public void swap() {
            Stack<Integer> temp = this.stack;
            this.stack = this.help;
            this.help = temp;
        }

    }
}
