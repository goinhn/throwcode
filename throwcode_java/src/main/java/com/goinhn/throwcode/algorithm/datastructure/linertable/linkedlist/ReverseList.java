package com.goinhn.throwcode.algorithm.datastructure.linertable.linkedlist;

/**
 * 反转单向和双向链表
 * leetode 206
 *
 * @author goinhn
 * @date 2020-08-27T20:05:04
 */
public class ReverseList {

    /**
     * 单链表
     */
    private static class Node {
        public int val;
        public Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 指针反转单链表
     * time:O(n)
     * space:O(1)
     */
    public Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 双链表
     */
    private static class DoubleNode {
        public int val;
        // 前指针
        public DoubleNode pre;
        // 后指针
        public DoubleNode next;

        public DoubleNode(int val, DoubleNode pre, DoubleNode next) {
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }

    /**
     * 指针反转双链表
     * time:O(n)
     * space:O(1)
     */
    public DoubleNode reverseList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }

}