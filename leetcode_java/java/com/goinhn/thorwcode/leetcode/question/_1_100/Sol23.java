package com.goinhn.thorwcode.leetcode.question._1_100;

/**
 * 23.合并K个升序列表
 *
 * @author goinhn
 * @date 2022/6/24
 */
public class Sol23 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 顺序合并
     * <p>
     * time:O(k^2 * n)
     * space:O(1)
     */
    private static class Solution1 {

        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }

            ListNode head = lists[0];
            for (int i = 1; i < lists.length; i++) {
                head = mergeListNode(head, lists[i]);
            }

            return head;
        }

        private ListNode mergeListNode(ListNode l1, ListNode l2) {
            ListNode pre = new ListNode();
            ListNode preRes = pre;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    pre.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    pre.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
                pre = pre.next;
            }

            if (l1 != null) {
                pre.next = l1;
            }
            if (l2 != null) {
                pre.next = l2;
            }

            return preRes.next;
        }

    }

    private static class Solution2 {

        public ListNode mergeKLists(ListNode[] lists) {
            return null;
        }

    }

}
