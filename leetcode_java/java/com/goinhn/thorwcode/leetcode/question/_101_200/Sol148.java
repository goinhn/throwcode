package com.goinhn.thorwcode.leetcode.question._101_200;

/**
 * 148.链表排序
 *
 * @author goinhn
 * @date 2022/8/17
 */
public class Sol148 {

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
     * 归并排序（自顶向下）
     * time:O(nlogn)
     * space:O(logn)
     */
    private static class Solution1 {

        public ListNode sortList(ListNode head) {
            return sortList(head, null);
        }

        private ListNode sortList(ListNode head, ListNode tail) {
            if (head == null) {
                return head;
            }

            // 断开成为新的链表
            if (head.next == tail) {
                head.next = null;
                return head;
            }

            // 找到中间节点进行分隔
            ListNode mid = findMiddleNode(head);
            ListNode listLeft = sortList(head, mid);
            ListNode listRight = sortList(mid, tail);
            ListNode listSort = merge(listLeft, listRight);

            return listSort;
        }

        /**
         * 合并链表
         */
        private ListNode merge(ListNode head1, ListNode head2) {
            ListNode dummyHead = new ListNode(-1);
            ListNode dummy = dummyHead;
            while (head1 != null && head2 != null) {
                if (head1.val < head2.val) {
                    dummy.next = head1;
                    head1 = head1.next;
                } else {
                    dummy.next = head2;
                    head2 = head2.next;
                }
                dummy = dummy.next;
            }

            if (head1 != null) {
                dummy.next = head1;
            }

            if (head2 != null) {
                dummy.next = head2;
            }

            return dummyHead.next;
        }

        /**
         * 找到中间节点
         */
        private ListNode findMiddleNode(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }

            return slow;
        }
    }

    /**
     * 归并排序（自底向上）
     * time:O(nlogn)
     * space:O(1)
     */
    private static class Solution2 {

        public ListNode sortList(ListNode head) {
            if (head == null) {
                return head;
            }

            int len = 0;
            ListNode node = head;
            while (node != null) {
                node = node.next;
                len++;
            }

            ListNode dummyHead = new ListNode(-1, head);
            for (int subLen = 1; subLen < len; subLen <<= 1) {
                ListNode pre = dummyHead;
                ListNode cur = dummyHead;
                while (cur != null) {
                    ListNode head1 = cur;
                    for (int i = 1; i < subLen && cur.next != null; i++) {
                        cur = cur.next;
                    }

                    ListNode head2 = cur.next;
                    cur.next = null;
                    cur = head2;
                    for (int i = 1; i < subLen && cur != null && cur.next != null; i++) {
                        cur = cur.next;
                    }

                    ListNode next = null;
                    if (cur != null) {
                        next = cur.next;
                        cur.next = null;
                    }

                    ListNode merged = merge(head1, head2);
                    pre.next = merged;
                    while (pre.next != null) {
                        pre = pre.next;
                    }

                    cur = next;
                }
            }

            return dummyHead.next;
        }

        /**
         * 合并链表
         */
        private ListNode merge(ListNode head1, ListNode head2) {
            ListNode dummyHead = new ListNode(-1);
            ListNode dummy = dummyHead;
            while (head1 != null && head2 != null) {
                if (head1.val < head2.val) {
                    dummy.next = head1;
                    head1 = head1.next;
                } else {
                    dummy.next = head2;
                    head2 = head2.next;
                }
                dummy = dummy.next;
            }

            if (head1 != null) {
                dummy.next = head1;
            }

            if (head2 != null) {
                dummy.next = head2;
            }

            return dummyHead.next;
        }

    }

}
