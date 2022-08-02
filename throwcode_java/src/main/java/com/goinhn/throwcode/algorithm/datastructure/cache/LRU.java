package com.goinhn.throwcode.algorithm.datastructure.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author goinhn
 * @date 2022/7/24
 */
public class LRU {

    /**
     * 外部数据加载器
     */
    public interface Loader<K, V> {
        V load(K key);
    }

    public static class Cache<K, V> {

        /**
         * 存储最大数量
         */
        private final int capacity;

        /**
         * 外部数据加载器
         */
        private final Loader<K, V> loader;

        /**
         * 对应节点的映射
         */
        private final Map<K, Node<V>> storeMap;

        /**
         * 当前存储数据的长度
         */
        private int len;

        /**
         * 链表头指针
         */
        private Node<V> head;

        /**
         * 链表尾指针
         */
        private Node<V> tail;

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

        public Cache(int capacity, Loader<K, V> loader) {
            this.capacity = capacity;
            this.loader = loader;
            this.len = 0;
            this.head = null;
            this.tail = null;
            this.storeMap = new HashMap<>();
        }

        /**
         * 获取当前对应的缓存值
         * time:O(1)
         */
        public V get(K key) {
            // 当前缓存存在
            if (storeMap.containsKey(key)) {
                // 加载数据
                Node<V> node = storeMap.get(key);

                // 不为头节点
                if (head != node) {
                    if (tail == node) {
                        tail = node.pre;
                    } else {
                        node.next.pre = node.pre;
                    }

                    // 将节点从链表中取出
                    node.pre.next = node.next;

                    // 放置在头节点
                    node.pre = null;
                    node.next = head;
                    head.pre = node;
                    head = node;
                }

                return node.v;

                // 当前缓存不存在
            } else {
                // 加载数据
                V v = loader.load(key);

                // 装载数据
                Node<V> node = new Node<>(v, null, null);
                storeMap.put(key, node);

                // 初始化情况
                if (head == null && tail == null) {
                    head = node;
                    tail = node;

                    // 已经存在链表情况
                } else {
                    // 将新节点放置在头部
                    node.next = head;
                    head.pre = node;
                    head = node;
                }

                // 如果超出长度限制，则淘汰队尾元素
                if (len + 1 > capacity) {
                    Node<V> tempNode = tail;
                    tail = tail.pre;
                    tempNode.pre = null;
                    tail.next = null;

                    // 移除当前key的映射
                    storeMap.remove(key);
                } else {
                    len++;
                }

                return node.v;
            }
        }

    }

    public static class CacheV2<K, V> {

        /**
         * 存储最大数量
         */
        private final int capacity;

        /**
         * 对应节点的映射
         */
        private final Map<K, Node<V>> storeMap;

        /**
         * 当前存储数据的长度
         */
        private int len;

        /**
         * 链表头指针
         */
        private Node<V> head;

        /**
         * 链表尾指针
         */
        private Node<V> tail;

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

        public CacheV2(int capacity) {
            this.capacity = capacity;
            this.len = 0;
            this.head = null;
            this.tail = null;
            this.storeMap = new HashMap<>();
        }

        /**
         * 获取缓存中的数据，不存在的话返回null
         */
        public V get(K key) {
            if (!storeMap.containsKey(key)) {
                return null;
            }

            // 加载数据
            Node<V> node = storeMap.get(key);

            // 不为头节点
            if (head != node) {
                if (tail == node) {
                    tail = node.pre;
                } else {
                    node.next.pre = node.pre;
                }

                // 将节点从链表中取出
                node.pre.next = node.next;

                // 放置在头节点
                node.pre = null;
                node.next = head;
                head.pre = node;
                head = node;
            }

            return node.v;
        }

        /**
         * 插入缓存数据
         */
        public void put(K key, V v) {
            // 装载数据
            Node<V> node = new Node<>(v, null, null);
            storeMap.put(key, node);

            // 初始化情况
            if (head == null && tail == null) {
                head = node;
                tail = node;

                // 已经存在链表情况
            } else {
                // 将新节点放置在头部
                node.next = head;
                head.pre = node;
                head = node;
            }

            // 如果超出长度限制，则淘汰队尾元素
            if (len + 1 > capacity) {
                Node<V> tempNode = tail;
                tail = tail.pre;
                tempNode.pre = null;
                tail.next = null;

                // 移除当前key的映射
                storeMap.remove(key);
            } else {
                len++;
            }
        }

    }
}
