package com.goinhn.leetcode._201_300._201_210;

/**
 * <p>
 * 反转一个单链表。
 * <p>
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * 时间复杂度:O(N)
 * 空间复杂度:O(1)
 * </p>
 *
 * @author goinhn
 * @date 2020-09-11T23:49:55
 */
public class Solution_206_1 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 使用暂存吸下一个节点的方式
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tempNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tempNode;
        }

        return prev;
    }
}













