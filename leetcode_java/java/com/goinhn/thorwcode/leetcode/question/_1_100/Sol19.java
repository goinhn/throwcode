package com.goinhn.thorwcode.leetcode.question._1_100;

import java.util.Stack;

/**
 * 19.删除链表的倒数第N个节点
 *
 * @author goinhn
 * @date 2022/7/14
 */
public class Sol19 {

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

        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode fastNode = head;
            ListNode slowNode = new ListNode(-1, head);
            ListNode resPre = slowNode;
            for (int i = 0; i < n; i++) {
                fastNode = fastNode.next;
            }

            while (fastNode != null) {
                fastNode = fastNode.next;
                slowNode = slowNode.next;
            }

            slowNode.next = slowNode.next.next;

            return resPre.next;
        }

    }

    /**
     * 栈操作
     * time:O(n)
     * space:O(n)
     */
    private static class Solution2 {

        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode headPre = new ListNode(-1, head);
            ListNode node = head;
            Stack<ListNode> stack = new Stack<>();
            while (node != null) {
                stack.push(node);
                node = node.next;
            }

            for (int i = 0; i < n; i++) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                headPre.next = headPre.next.next;
            } else {
                ListNode nNode = stack.pop();
                nNode.next = nNode.next.next;
            }

            return headPre.next;
        }

    }

}
