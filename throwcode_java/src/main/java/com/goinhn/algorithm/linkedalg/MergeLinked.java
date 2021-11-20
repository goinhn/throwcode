package com.goinhn.algorithm.linkedalg;

/**
 * <p>
 * 合并两个链表
 * <p>
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * </p>
 *
 * @author goinhn
 * @date 2020-12-04T11:55:00
 */
public class MergeLinked {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 使用递归的方法进行解决
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeLinked(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeLinked(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeLinked(l1, l2.next);
            return l2;
        }
    }

}
