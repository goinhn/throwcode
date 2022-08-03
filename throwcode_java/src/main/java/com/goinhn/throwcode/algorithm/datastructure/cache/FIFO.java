package com.goinhn.throwcode.algorithm.datastructure.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author goinhn
 * @date 2022/8/2
 */
public class FIFO {

    public static class Cache<K, V> {

        private final int capacity;

        private Node<V> head;

        private Node<V> tail;

        private int len;

        private final Map<K, Node<V>> storeMap;

        /**
         * 存储节点
         */
        private static class Node<V> {

            /**
             * 存储对应的值
             */
            V v;

            /**
             * 指向前一个节点的指针
             */
            Node<V> pre;

            /**
             * 指向后一个节点的指针
             */
            Node<V> next;

            public Node(V v, Node<V> pre, Node<V> next) {
                this.v = v;
                this.pre = pre;
                this.next = next;
            }

        }

        public Cache(int capacity) {
            this.capacity = capacity;
            this.head = null;
            this.tail = null;
            this.len = 0;
            this.storeMap = new HashMap<>(capacity);
        }

        public V get(K key) {
            if (storeMap.containsKey(key)) {
                return storeMap.get(key).v;
            }

            return null;
        }

        public void set(K key, V v) {
            if (storeMap.containsKey(key)) {
                return;
            }

            // 加载节点
            Node<V> node = new Node<>(v, null, null);

            storeMap.put(key, node);

            // 初始化链表
            if (head == null || tail == null) {
                head = node;
                tail = node;

                // 添加到尾部
            } else {
                tail.next = node;
                node.pre = tail;
                tail = node;
            }

            // 超出限制则头部弹出
            if (len + 1 > capacity) {
                head.next.pre = null;
                Node<V> nodeTemp = head;
                head = head.next;
                nodeTemp.next = null;
            } else {
                len++;
            }

        }

    }

}
