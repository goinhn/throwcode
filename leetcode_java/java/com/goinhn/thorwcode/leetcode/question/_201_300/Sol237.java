package com.goinhn.thorwcode.leetcode.question._201_300;

/**
 * 237.删除链表中的节点
 *
 * @author goinhn
 * @date 2021/12/12
 */
public class Sol237 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * time:O(1)
     * space:O(1)
     */
    private static class Solution1 {
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
