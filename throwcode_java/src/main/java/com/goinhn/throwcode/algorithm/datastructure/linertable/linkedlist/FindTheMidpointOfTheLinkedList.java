package com.goinhn.throwcode.algorithm.datastructure.linertable.linkedlist;

/**
 * 找到链表的中间节点
 * 如果存在重复的则取第二个节点
 * leetcode 876
 *
 * @author goinhn
 * @date 2022/8/5
 */
public class FindTheMidpointOfTheLinkedList {

    public static class Node {
        int val;
        Node next;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * time:O(n)
     * space:O(1)
     */
    public Node findMiddleNode(Node head) {
        if (head == null) {
            return null;
        }

        Node fast = new Node(-1, head);
        Node slow = new Node(-1, head);
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow.next;
    }

}
