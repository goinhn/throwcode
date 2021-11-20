package com.goinhn.algorithm.datastructure.linertable.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * leetcode 142
 *
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null
 * <p>
 * 时间复杂度:O(N)
 * 空间复杂度:O(1)
 * </p>
 *
 * @author goinhn
 * @date 2020-09-12T11:22:18
 */
public class LinkedListCycleII {

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

    /**
     * 使用哈希表的形式来存储不重复的节点，出现重复则为入环节点
     *
     * @param head
     * @return
     */
    public ListNode detectCycleHashTable(ListNode head) {
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
