package com.goinhn.throwcode.codinginterviews.liked_list;

/**
 * 10.反转链表
 *
 * @author goinhn
 * @date 2020-12-03T22:15:12
 */
public class Jz10 {

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 指针反转
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {
        public ListNode reverseList(ListNode head) {
            ListNode next = null;
            ListNode pre = null;

            while (head != null) {
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }

            return pre;
        }
    }

    /**
     * 递归
     * time:O(n)
     * space:O(n)
     */
    private static class Solution2 {
        private ListNode newHead;

        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            reverseHelper(head);
            head.next = null;
            return newHead;
        }

        private ListNode reverseHelper(ListNode head) {
            if (head.next == null) {
                newHead = head;
                return head;
            }
            ListNode pre = reverseHelper(head.next);
            pre.next = head;
            return head;
        }
    }

    /**
     * 递归
     * time:O(n)
     * space:O(n)
     */
    private static class Solution3 {
        public ListNode reverseList(ListNode head) {
            return recur(head, null);
        }

        private ListNode recur(ListNode cur, ListNode pre) {
            if (cur == null) {
                return pre;
            }
            ListNode res = recur(cur.next, cur);
            cur.next = pre;
            return res;
        }
    }
}
