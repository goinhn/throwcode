package com.goinhn.sworddirectoffer;

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
public class JZ16 {

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
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeLinked(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {
            list1.next = mergeLinked(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeLinked(list1, list2.next);
            return list2;
        }
    }

}
