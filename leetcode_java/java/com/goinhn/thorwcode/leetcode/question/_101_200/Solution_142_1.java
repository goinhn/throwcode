package com.goinhn.thorwcode.leetcode.question._101_200;

/**
 * <p>
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null
 * <p>
 * 时间复杂度:O(N)
 * 空间复杂度:O(1)
 * </p>
 *
 * @author goinhn
 * @date 2020-09-12T11:22:18
 */
public class Solution_142_1 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 快慢指针，最后头节点和相遇节点到入环节点位置的距离是一样的
     *
     * @param head
     * @return
     */
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
