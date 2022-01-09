package com.goinhn.thorwcode.leetcode.competition.biweeklycontest._69;

import java.util.Stack;

/**
 * @author goinhn
 * @date 2022/01/08
 */
public class Sol2 {

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

    private static class Solution1 {
        public int pairSum(ListNode head) {
            ListNode fastNode = new ListNode();
            ListNode slowNode = fastNode;
            fastNode.next = head;
            while(fastNode.next != null) {
                fastNode = fastNode.next.next;
                slowNode = slowNode.next;
            }
            ListNode middleNode = slowNode;
            fastNode = slowNode;
            slowNode = new ListNode();
            slowNode.next = head;
            Stack<ListNode> stack = new Stack<>();
            while (fastNode.next != null) {
                fastNode = fastNode.next;
                slowNode = slowNode.next;
                stack.push(slowNode);
            }

            int maxSum = 0;
            while(middleNode.next != null) {
                middleNode = middleNode.next;
                int tempNum = stack.pop().val + middleNode.val;
                maxSum = Math.max(tempNum, maxSum);
            }
            return maxSum;
        }
    }
}
