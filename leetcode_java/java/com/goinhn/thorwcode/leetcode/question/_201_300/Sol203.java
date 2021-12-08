package com.goinhn.thorwcode.leetcode.question._201_300;

/**
 * 203.移除链表元素
 *
 * @author goinhn
 * @date 2021/12/8
 */
public class Sol203 {

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
     * 移动指针
     * <p>
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {
        public ListNode removeElements(ListNode head, int val) {
            ListNode resultHead = new ListNode();
            resultHead.next = head;
            ListNode tempHead = resultHead;
            while (tempHead.next != null) {
                if (tempHead.next.val == val) {
                    tempHead.next = tempHead.next.next;
                } else {
                    tempHead = tempHead.next;
                }
            }
            return resultHead.next;
        }
    }

    /**
     * 递归
     *
     * time:O(n)
     * space:O(n)
     */
    private static class Solution2 {
        public ListNode removeElements(ListNode head, int val) {
            if (head == null) {
                return null;
            }
            head.next = removeElements(head.next, val);
            return head.val == val ? head.next : head;
        }
    }
}
