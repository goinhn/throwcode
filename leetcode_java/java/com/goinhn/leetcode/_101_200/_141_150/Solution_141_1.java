package com.goinhn.leetcode._101_200._141_150;

/**
 * <p>
 * 给定一个链表，判断链表中是否有环。
 *
 * 时间复杂度:O(N)
 * 空间复杂度:O(1)
 * </p>
 *
 * @author goinhn
 * @date 2020-09-12T11:07:51
 */
public class Solution_141_1 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 快慢指针，有环则必相遇
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

}
