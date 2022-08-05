package com.goinhn.thorwcode.leetcode.question._101_200;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 143.重排链表
 *
 * @author goinhn
 * @date 2022/8/5
 */
public class Sol143 {

    public static class ListNode {
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
     * 利用栈进行反转
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {

        public void reorderList(ListNode head) {
            if (head == null) {
                return;
            }

            Stack<ListNode> stack = new Stack<>();
            ListNode headCir = head;
            while (headCir.next != null) {
                stack.push(headCir.next);
                headCir = headCir.next;
            }

            int limit = stack.size() / 2;
            boolean flag = stack.size() % 2 == 0;
            while (stack.size() > limit) {
                ListNode nextNode = head.next;
                head.next = stack.pop();
                head = head.next;
                head.next = nextNode;
                head = head.next;
            }

            if (flag) {
                head.next = null;
            } else {
                head.next.next = null;
            }
        }

    }

    /**
     * 线性表
     * time:O(n)
     * space:O(n)
     */
    private static class Solution2 {

        public void reorderList(ListNode head) {
            if (head == null) {
                return;
            }

            List<ListNode> list = new ArrayList<>();
            ListNode headCir = head;
            while (headCir.next != null) {
                list.add(headCir.next);
                headCir = headCir.next;
            }

            int left = 0;
            int right = list.size() - 1;

            while (left < right) {
                head.next = list.get(right);
                head = head.next;
                head.next = list.get(left);
                head = head.next;

                left++;
                right--;
            }

            if (left == right) {
                head.next = list.get(left);
                head = head.next;
            }

            head.next = null;
        }

    }

    /**
     * 查找链表的中点，翻转后部分链表，合并两个链表
     * time:O(n)
     * space:O(1)
     */
    private static class Solution3 {

        public void reorderList(ListNode head) {
            if (head == null) {
                return;
            }

            ListNode middleNode = findTheMiddlePoint(head.next);

            ListNode rightPartNode = reverseList(middleNode);
            ListNode leftPartNode = head.next;
            if (leftPartNode == rightPartNode) {
                return;
            }

            while (leftPartNode != null && rightPartNode != null) {
                head.next = rightPartNode;
                head = head.next;
                rightPartNode = rightPartNode.next;

                head.next = leftPartNode;
                head = head.next;
                leftPartNode = leftPartNode.next;
            }

            head.next = null;
        }

        /**
         * 找到中间节点
         */
        private ListNode findTheMiddlePoint(ListNode head) {
            ListNode fast = new ListNode(-1, head);
            ListNode slow = new ListNode(-1, head);
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }

            return slow.next;
        }

        /**
         * 反转右侧链表
         */
        private ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode next = null;
            while (head != null) {
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }

            return pre;
        }

    }

}