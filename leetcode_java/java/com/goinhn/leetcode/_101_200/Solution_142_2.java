package com.goinhn.leetcode._101_200;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * 时间复杂度:O(N)
 * 空间复杂度:O(N)
 * </p>
 *
 * @author goinhn
 * @date 2020-09-12T12:59:15
 */
public class Solution_142_2 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 使用哈希表的形式来存储不重复的节点，出现重复则为入环节点
     *
     * @param head
     * @return
     */
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
