package com.goinhn.throwcode.codinginterviews.pointer;

import java.util.HashSet;
import java.util.Set;

/**
 * 52.两个链表的公共节点
 *
 * @author goinhn
 * @date 2022/1/5
 */
public class Jz52 {

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 双指针，交换遍历
     * time:O(m + n)
     * space:O(1)
     */
    private static class Solution1 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            ListNode nodeA = headA;
            ListNode nodeB = headB;

            while (nodeA != null || nodeB != null) {
                if (nodeA == null) {
                    nodeA = headB;
                }
                if (nodeB == null) {
                    nodeB = headA;
                }
                if (nodeA == nodeB) {
                    return nodeA;
                }
                nodeA = nodeA.next;
                nodeB = nodeB.next;
            }

            return null;
        }
    }

    /**
     * 哈希表
     * time:O(n)
     * space:O(n)
     */
    private static class Solution2 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            ListNode nodeA = headA;
            ListNode nodeB = headB;
            Set<ListNode> nodeSet = new HashSet<>();
            while (nodeA != null || nodeB != null) {
                if (nodeA != null) {
                    if (nodeSet.contains(nodeA)) {
                        return nodeA;
                    }
                    nodeSet.add(nodeA);
                    nodeA = nodeA.next;
                }
                if (nodeB != null) {
                    if (nodeSet.contains(nodeB)) {
                        return nodeB;
                    }
                    nodeSet.add(nodeB);
                    nodeB = nodeB.next;
                }
            }

            return null;
        }
    }
}

