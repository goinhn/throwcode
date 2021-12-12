package com.goinhn.thorwcode.leetcode.question._201_300;

import java.util.Stack;

/**
 * 234.回文链表
 *
 * @author goinhn
 * @date 2021/12/12
 */
public class Sol234 {

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
     * <p>
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {
        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return true;
            }

            ListNode slowIndex = head;
            ListNode fastIndex = head;
            while (fastIndex != null && fastIndex.next != null) {
                slowIndex = slowIndex.next;
                fastIndex = fastIndex.next.next;
            }

            if (fastIndex == null) {
                fastIndex = slowIndex;
            } else {
                fastIndex = slowIndex.next;
            }
            Stack<Integer> stack = new Stack<>();
            while (fastIndex != null) {
                stack.add(fastIndex.val);
                fastIndex = fastIndex.next;
            }

            slowIndex = head;
            while (!stack.isEmpty()) {
                if (slowIndex.val != stack.pop()) {
                    return false;
                }
                slowIndex = slowIndex.next;
            }
            return true;
        }
    }

    /**
     * 递归
     * time:O(n)
     * space:O(n)
     */
    private static class Solution2 {

        private ListNode headNode;

        public boolean isPalindrome(ListNode head) {
            headNode = head;
            return recursivelyCheck(head);
        }

        private boolean recursivelyCheck(ListNode root) {
            if (root != null) {
                if (!recursivelyCheck(root.next)) {
                    return false;
                }
                if (root.val != headNode.val) {
                    return false;
                }
                headNode = headNode.next;
            }
            return true;
        }
    }
}
