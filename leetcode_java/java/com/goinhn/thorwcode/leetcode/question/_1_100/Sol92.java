package com.goinhn.thorwcode.leetcode.question._1_100;

/**
 * 92.反转链表II
 *
 * @author goinhn
 * @date 2022/6/24
 */
public class Sol92 {

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
     * 模拟反转
     * <p>
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {

        public ListNode reverseBetween(ListNode head, int left, int right) {
            // 使用一个头节点的前置虚节点来保存返回的结果
            ListNode headPre = new ListNode(-1, head);
            ListNode nodePre = headPre;
            // 找到开始反转的位置
            for (int i = 1; i < left; i++) {
                nodePre = nodePre.next;
            }

            ListNode node = nodePre.next;
            // 保存反转开始的前置节点
            ListNode midHeadPre = nodePre;
            // 保存反转开始的节点
            ListNode midHead = node;
            for (int i = 0; i < right - left + 1; i++) {
                ListNode tempNode = node.next;
                node.next = nodePre;
                nodePre = node;
                node = tempNode;
            }
            // 将反转后的链表重新融入原有的链表中
            midHeadPre.next = nodePre;
            midHead.next = node;

            return headPre.next;
        }

    }

}
