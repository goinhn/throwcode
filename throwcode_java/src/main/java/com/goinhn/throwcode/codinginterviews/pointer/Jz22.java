package com.goinhn.throwcode.codinginterviews.pointer;


/**
 * 22.链表中倒数第k个节点
 *
 * @author goinhn
 * @date 2020-12-03T22:31:02
 */
public class Jz22 {

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 快慢指针
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {
        public ListNode getKthFromEnd(ListNode head, int k) {
            if (head == null || k < 1) {
                return null;
            }
            ListNode slowNode = head;
            ListNode fastNode = head;
            for (int i = 0; i < k; i++) {
                if (fastNode != null) {
                    fastNode = fastNode.next;
                } else {
                    return null;
                }
            }
            while (fastNode != null) {
                slowNode = slowNode.next;
                fastNode = fastNode.next;
            }
            return slowNode;
        }
    }

    /**
     * 快慢指针
     * time:O(n)
     * space:O(1)
     */
    private static class Solution2 {
        public ListNode getKthFromEnd(ListNode head, int k) {
            if (head == null || k < 1) {
                return null;
            }

            ListNode slowNode = head;
            ListNode fastNode = head;
            int kTemp = k;
            int count = 0;
            while (fastNode != null) {
                fastNode = fastNode.next;
                count++;
                if (kTemp < 1) {
                    slowNode = slowNode.next;
                }
                kTemp--;
            }
            if (count < k) {
                return null;
            }
            return slowNode;
        }
    }

}
