package com.goinhn.algorithm.linkedalg;

/**
 * <p>
 *
 * </p>
 *
 * @author goinhn
 * @date 2020-12-03T22:15:12
 */
public class ReverseLinked {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseLinked(ListNode head) {
        ListNode next = null;
        ListNode pre = null;

        while (head != null) {
//            保存下一个节点
            next = head.next;
//            当前节点指向上一个节点
            head.next = pre;
//            保存原始的上一个节点
            pre = head;
//            指针体跳到下一个节点
            head = next;
        }

        return pre;
    }
}
