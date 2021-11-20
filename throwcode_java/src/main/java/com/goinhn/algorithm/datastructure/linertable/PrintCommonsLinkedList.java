package com.goinhn.algorithm.datastructure.linertable;

/**
 * <p>
 * 打印两个公共链表的有序部分
 * </p>
 *
 * @author goinhn
 * @date 2020-08-28T11:53:05
 */
public class PrintCommonsLinkedList {

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node printCommonsLinkedList(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        Node head = null;
        Node headResult = null;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                head1 = head1.next;
            } else if (head1.data > head2.data) {
                head2 = head2.next;
            } else {
                if (head == null) {
                    head = head1;
                    headResult = head;
                } else {
                    head.next = head1;
                    head = head.next;
                }
                head1 = head1.next;
                head2 = head2.next;
            }
        }

        return headResult;
    }

    public static void main(String[] args) {

    }

}
