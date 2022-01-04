package com.goinhn.throwcode.codinginterviews.pointer;

/**
 * 18.删除链表的节点
 *
 * @author goinhn
 * @date 2022/1/4
 */
public class Jz18 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 指针遍历
     * time:O(n)
     * space:o(1)
     */
    private static class Solution1 {
        public ListNode deleteNode(ListNode head, int val) {
            if (head == null) {
                return null;
            }
            ListNode preNode = new ListNode(-1);
            preNode.next = head;
            ListNode resultNode = preNode;
            while (preNode.next != null) {
                if (preNode.next.val == val) {
                    preNode.next = preNode.next.next;
                    return resultNode.next;
                }
                preNode = preNode.next;
            }

            return resultNode.next;
        }
    }

    /**
     * 递归
     * time:O(n)
     * space:O(n)
     */
    private static class Solution2 {
        public ListNode deleteNode(ListNode head, int val) {
            if (head == null) {
                return null;
            }
            if (head.val == val) {
                return head.next;
            } else {
                head.next = deleteNode(head.next, val);
            }
            return head;
        }
    }
}

