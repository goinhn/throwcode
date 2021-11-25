package com.goinhn.thorwcode.leetcode.question._101_200;

import java.util.HashSet;
import java.util.Set;

/**
 * 141.环形链表
 *
 * @author goinhn
 * @date 2021/11/25
 */
public class Sol141 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 快慢指针
     * <p>
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {
        public boolean hasCycle(ListNode head) {
            ListNode beforeNode = head;
            ListNode afterNode = head;
            while (beforeNode != null && beforeNode.next != null) {
                beforeNode = beforeNode.next.next;
                afterNode = afterNode.next;
                if (beforeNode == afterNode) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 利用哈希表进行去重
     *
     * time:O(n)
     * space:O(n)
     */
    private static class Solution2 {
        public boolean hasCycle(ListNode head) {
            Set<ListNode> nodeSet = new HashSet<>();
            ListNode indexNode = head;
            while (indexNode != null) {
                if (nodeSet.contains(indexNode)) {
                    return true;
                }
                nodeSet.add(indexNode);
                indexNode = indexNode.next;
            }
            return false;
        }
    }
}
