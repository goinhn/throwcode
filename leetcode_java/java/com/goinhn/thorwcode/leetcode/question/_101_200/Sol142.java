package com.goinhn.thorwcode.leetcode.question._101_200;

import java.util.HashSet;
import java.util.Set;

/**
 * @author goinhn
 * @date 2022/6/22
 */
public class Sol142 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    /**
     * 快慢指针，最后头节点和相遇节点到入环节点位置的距离是一样的
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {

        public ListNode detectCycle(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    fast = head;
                    while (fast != slow) {
                        fast = fast.next;
                        slow = slow.next;
                    }
                    return fast;
                }
            }

            return null;
        }

    }

    /**
     * 使用哈希表的形式来存储不重复的节点，出现重复则为入环节点
     * time:O(n)
     * space:O(n)
     */
    private static class Solution2 {

        public ListNode detectCycle(ListNode head) {
            Set<ListNode> set = new HashSet<>();
            while (head != null) {
                if (set.contains(head)) {
                    return head;
                } else {
                    set.add(head);
                    head = head.next;
                }
            }

            return null;
        }

    }

}
