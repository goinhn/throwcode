package com.goinhn.algorithm.datastructure.linertable;

/**
 * <p>
 * 数组模拟栈和队列
 * </p>
 *
 * @author goinhn
 * @date 2020-08-26T17:11:48
 */
public class ArrayToStackQueue {

    public static class ArrayStack {

        private final Integer[] arr;
        private Integer size;

        public ArrayStack(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            size = 0;
        }

        /**
         * 栈是否为空
         *
         * @return
         */
        public Boolean isEmpty() {
            return size == 0;
        }

        /**
         * 返回栈长度
         *
         * @return
         */
        public Integer size() {
            return size;
        }

        /**
         * 返回栈顶元素
         *
         * @return
         */
        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return arr[size - 1];
        }

        /**
         * 入栈
         *
         * @param obj
         */
        public void push(int obj) {
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("The stack is full");
            }
            arr[size++] = obj;
        }

        /**
         * 出栈
         *
         * @return
         */
        public Integer pop() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("The stack is empty");
            }
            return arr[--size];
        }

        public static void main(String[] args) {

        }
    }


    public static class ArrayQueue {

        private final Integer[] arr;
        private Integer first;
        private Integer last;
        private Integer size;

        public ArrayQueue(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            first = 0;
            last = 0;
            size = 0;
        }

        /**
         * 判断是否为空
         *
         * @return
         */
        public Boolean isEmpty() {
            return size == 0;
        }

        /**
         * 返回栈的长度
         *
         * @return
         */
        public Integer size() {
            return size;
        }

        /**
         * 查看队首元素
         *
         * @return
         */
        public Integer peekFirst() {
            if (size == 0) {
                return null;
            }
            return arr[first];
        }

        /**
         * 查看队尾元素
         *
         * @return
         */
        public Integer peekLast() {
            if (size == 0) {
                return null;
            }
            return arr[last];
        }

        /**
         * 入队
         *
         * @param obj
         */
        public void push(int obj) {
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("the queue is full");
            }

            size++;
            arr[last] = obj;
            last = last == arr.length - 1 ? 0 : last + 1;
        }

        /**
         * 出队
         *
         * @return
         */
        public Integer poll() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("the queue is empty");
            }

            size--;
            int temp = first;
            first = first == arr.length - 1 ? 0 : first + 1;
            return arr[temp];
        }

        public static void main(String[] args) {

        }
    }
}
