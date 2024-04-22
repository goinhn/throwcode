package com.goinhn.throwcode.algorithm.datastructure.linertable.linkedlist;

/**
 * 反转单向和双向链表
 * leetcode 206
 *
 * @author goinhn
 * @date 2020-08-27T20:05:04
 */
public class ReverseList {

    public static class Node {
        int val;
        Node pre;
        Node next;

        Node(int val, Node pre, Node next) {
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }

    /**
     * 指针反转单链表
     * time:O(n)
     * space:O(1)
     */
    public Node reverseSingleList(Node head) {
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
     * 指针反转双链表
     * time:O(n)
     * space:O(1)
     */
    public Node reverseDoubleList(Node head) {
        Node pre = null;
        Node next = null;
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