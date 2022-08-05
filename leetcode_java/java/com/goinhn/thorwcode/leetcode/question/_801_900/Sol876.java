package com.goinhn.thorwcode.leetcode.question._801_900;

/**
 * 876.链表的中间节点
 *
 * @author goinhn
 * @date 2022/8/5
 */
public class Sol876 {

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
     * 快慢指针
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {
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

}
