package com.goinhn.throwcode.algorithm.datastructure.linertable.linkedlist;

/**
 * 找到链表的中间节点
 * 如果存在重复的则取第二个节点
 *
 * @author goinhn
 * @date 2022/8/5
 */
public class FindTheMidpointOfTheLinkedList {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * time:O(n)
     * space:O(1)
     */
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode fast = new ListNode(-1, head);
        ListNode slow = new ListNode(-1, head);
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow.next;
    }

}
