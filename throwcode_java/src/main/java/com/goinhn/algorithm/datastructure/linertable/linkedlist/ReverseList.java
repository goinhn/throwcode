package com.goinhn.algorithm.datastructure.linertable.linkedlist;

/**
 * <p>
 * leetode 206
 *
 * 反转单向和双向链表
 * <p>
 * 分别实现反转单向链表和反转双向链表的函数
 * <p>
 * 如果链表长度为N，时间复杂度要求为O(N)，额外空间复杂度要求为O(1)
 * </p>
 *
 * @author goinhn
 * @date 2020-08-27T20:05:04
 */
public class ReverseList {

    /**
     * 单链表
     */
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 反转单链表，使用额外的O(N)空间复杂度可以使用栈的结构
     *
     * @param head
     * @return
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
    public static class DoubleNode {
        public int value;
        // 前指针
        public DoubleNode pre;
        // 后指针
        public DoubleNode next;

        public DoubleNode(int data) {
            this.value = data;
        }
    }

    /**
     * 反转双链表，使用额外的O(N)空间复杂度可以使用栈的结构
     *
     * @param head
     * @return
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

    public void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public void printDoubleLinkedList(DoubleNode head) {
        System.out.print("Double Linked List: ");
        DoubleNode end = null;
        while (head != null) {
            System.out.print(head.value + " ");
            end = head;
            head = head.next;
        }
        System.out.print("| ");
        while (end != null) {
            System.out.print(end.value + " ");
            end = end.pre;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();

        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        reverseList.printLinkedList(head1);
        head1 = reverseList.reverseList(head1);
        reverseList.printLinkedList(head1);
        DoubleNode head2 = new DoubleNode(1);
        head2.next = new DoubleNode(2);
        head2.next.pre = head2;
        head2.next.next = new DoubleNode(3);
        head2.next.next.pre = head2.next;
        head2.next.next.next = new DoubleNode(4);
        head2.next.next.next.pre = head2.next.next;
        reverseList.printDoubleLinkedList(head2);
        reverseList.printDoubleLinkedList(reverseList.reverseList(head2));
    }

}