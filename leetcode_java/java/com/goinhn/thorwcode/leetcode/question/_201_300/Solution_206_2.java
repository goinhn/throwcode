package com.goinhn.thorwcode.leetcode.question._201_300;

/**
 * <p>
 * 时间复杂度:O(N)
 * 空间复杂度:O(N)
 * </p>
 *
 * @author goinhn
 * @date 2020-09-11T23:49:55
 */
public class Solution_206_2 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 使用递归的方式来进行，假设的链表的部分已经反转，如何反转剩余的部分
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        // prev指针表示的是上一个反转前head节点的后继指针，以及反转后head节点的前驱指针
        ListNode prev = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return prev;
    }
}













