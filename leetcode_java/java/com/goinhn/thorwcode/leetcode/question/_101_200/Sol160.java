package com.goinhn.thorwcode.leetcode.question._101_200;

import java.util.HashSet;
import java.util.Set;

/**
 * 160.相交链表
 *
 * @author goinhn
 * @date 2021/11/27
 */
public class Sol160 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 哈希表
     * <p>
     * time:(n)
     * space:(n)
     */
    private static class Solution1 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            Set<ListNode> nodeSet = new HashSet<>();
            ListNode node = headA;
            while (node != null) {
                nodeSet.add(node);
                node = node.next;
            }
            node = headB;
            while (node != null) {
                if (nodeSet.contains(node)) {
                    return node;
                }
                node = node.next;
            }
            return null;
        }
    }

    /**
     * 双指针，使得两个指针位于同样的起点
     * <p>
     * time:O(n)
     * space:O(1)
     */
    private static class Solution2 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode nodeA = headA;
            ListNode nodeB = headB;
            while (nodeA != null && nodeB != null) {
                nodeA = nodeA.next;
                nodeB = nodeB.next;
            }
            ListNode resultA = helper(nodeA, nodeB, headA, headB);
            ListNode resultB = helper(nodeB, nodeA, headB, headA);
            return resultA == null ? resultB : resultA;
        }

        private ListNode helper(ListNode nodeFast, ListNode nodeSlow, ListNode headFast, ListNode headSlow) {
            if (nodeFast == null) {
                nodeFast = headSlow;
                while (nodeFast != null && nodeSlow != null) {
                    nodeFast = nodeFast.next;
                    nodeSlow = nodeSlow.next;
                }
                nodeSlow = headFast;
                while (nodeFast != null && nodeSlow != null) {
                    if (nodeFast == nodeSlow) {
                        return nodeFast;
                    }
                    nodeFast = nodeFast.next;
                    nodeSlow = nodeSlow.next;
                }
            }
            return null;
        }
    }

    /**
     * 双指针，使得两个指针位于同样的起点
     * <p>
     * time:O(n)
     * space:O(1)
     */
    private static class Solution3 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            ListNode pA = headA, pB = headB;
            while (pA != pB) {
                pA = pA == null ? headB : pA.next;
                pB = pB == null ? headA : pB.next;
            }
            return pA;
        }
    }
}
