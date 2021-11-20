package com.goinhn.algorithm.linkedalg;

/**
 * <p>
 * 删除链表的倒数第N个节点
 * <p>
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * </p>
 *
 * @author goinhn
 * @date 2020-12-04T11:42:13
 */
public class DeleteToTail {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteToTail(ListNode head, int k) {
        if (head == null || k < 1) {
            return null;
        }

        ListNode kNode = head;
//        设置一个哑节点指向前一个位置，保证找到k个节点的时候，指针的下一个位置指向第k个节点
        ListNode location = new ListNode(-1);
        location.next = head;

        int count = 0;
        int kTemp = 0;

        while (kNode != null) {
            kNode = kNode.next;
            count++;
            if (kTemp < 1) {
                location = location.next;
            }

            kTemp--;
        }

        if (count < k) {
            return head;
        }

        location.next = location.next.next;

        return head;
    }
}
