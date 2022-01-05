package com.goinhn.throwcode.codinginterviews.pointer;

/**
 * 25.合并两个排序的链表
 *
 * @author goinhn
 * @date 2020-12-04T11:55:00
 */
public class Jz25 {

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 迭代
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            ListNode resultNode = new ListNode(-1);
            ListNode tempNode = resultNode;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    tempNode.next = l1;
                    l1 = l1.next;
                } else {
                    tempNode.next = l2;
                    l2 = l2.next;
                }
                tempNode = tempNode.next;
            }
            if (l1 != null) {
                tempNode.next = l1;
            }
            if (l2 != null) {
                tempNode.next = l2;
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
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }

            if (l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }
    }

}
