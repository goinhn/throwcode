package com.goinhn.throwcode.algorithm.datastructure.linertable.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，判断链表中是否有环
 * leetcode 141
 *
 * @author goinhn
 * @date 2020-09-12T11:07:51
 */
public class FindTheCycleInLinkedList {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 快慢指针，有环则必相遇
     * time:O(n)
     * space:O(1)
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

    /**
     * 使用哈希表，出现重复的节点则存在环
     * time:O(n)
     * space:O(n)
     */
    public boolean hasCycleHashTable(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
                head = head.next;
            }
        }

        return false;
    }

}
