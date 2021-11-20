package com.goinhn.sworddirectoffer;

/**
 * <p>
 * 反转链表
 * <p>
 * 输入一个链表，反转链表后，输出新链表的表头。
 * </p>
 *
 * @author goinhn
 * @date 2020-12-03T22:15:12
 */
public class JZ15 {

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
