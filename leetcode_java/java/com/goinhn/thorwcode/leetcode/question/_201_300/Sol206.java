package com.goinhn.thorwcode.leetcode.question._201_300;

/**
 * 206.反转链表
 *
 * @author goinhn
 * @date 2021/12/9
 */
public class Sol206 {

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
     * 指针迭代
     * <p>
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {
        public ListNode reverseList(ListNode head) {
            ListNode preNode = null;
            ListNode nowNode = head;
            while (nowNode != null) {
                ListNode nextNode = nowNode.next;
                nowNode.next = preNode;
                preNode = nowNode;
                nowNode = nextNode;
            }
            return preNode;
        }
    }

    /**
     * 递归
     * <p>
     * time:O(n)
     * space:O(n)
     */
    private static class Solution2 {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode newNode = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return newNode;
        }
    }
}
