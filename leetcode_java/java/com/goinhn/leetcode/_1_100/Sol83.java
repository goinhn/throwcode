package com.goinhn.leetcode._1_100;

/**
 * 83.删除排序链表中的重复元素
 *
 * @author goinhn
 * @date 2021/11/20
 */
public class Sol83 {

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
    private static class Solution1 {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode now = head;
            ListNode nextNode = head.next;
            while (nextNode != null) {
                if (now.val == nextNode.val) {
                    now.next = nextNode.next;
                } else {
                    now = now.next;
                }
                nextNode = nextNode.next;
            }
            return head;
        }
    }

}
