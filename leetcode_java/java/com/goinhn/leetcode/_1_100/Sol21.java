/*
 * Copyright (C) 2021 Baidu, Inc. All Rights Reserved.
 */
package com.goinhn.leetcode._1_100;

/**
 * 21.合并两个有序链表
 *
 * @author fangwenzhan
 * @date 2021-11-05
 **/
public class Sol21 {

    public static class ListNode {
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
     * 顺序比较
     * 两个链表的长度分别为m、n
     * <p>
     * time:O(n + m)
     * space:O(1)
     */
    private static class Solution1 {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode tempHead = new ListNode(-1);
            ListNode resultHead = tempHead;

            if (null == l1 && null == l2) {
                return null;
            }
            if (l1 == null || l2 == null) {
                return l1 == null ? l2 : l1;
            }

            while (null != l1 && null != l2) {
                if (l1.val < l2.val) {
                    tempHead.next = l1;
                    l1 = l1.next;
                } else {
                    tempHead.next = l2;
                    l2 = l2.next;
                }
                tempHead = tempHead.next;
            }

            if (l1 != null) {
                tempHead.next = l1;
            }
            if (l2 != null) {
                tempHead.next = l2;
            }

            return resultHead.next;
        }
    }

    private static class Solution2 {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (null == l1) {
                return l2;
            } else if (null == l2) {
                return l1;
            } else if (l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }
    }
}
