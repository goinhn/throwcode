package com.goinhn.thorwcode.leetcode.question._101_200;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 时间复杂度:O(N)
 * 空间复杂度:O(N)
 * </p>
 *
 * @author goinhn
 * @date 2020-09-12T11:07:51
 */
public class Solution_141_2 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 使用哈希表，出现重复的节点则存在环
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
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
