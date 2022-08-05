package com.goinhn.throwcode.algorithm.datastructure.linertable.linkedlist;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表
 * leetcode 24
 *
 * @author goinhn
 * @date 2020-09-12T01:28:46
 */
public class SwapNodesInPairs {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 指针移动进行交换
     * time:O(n)
     * space:O(1)
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyNode = new ListNode(-1, head);
        ListNode preNode = dummyNode;
        ListNode node = head;
        while (node != null && node.next != null) {
            // 设置前后两个节点
            ListNode firstNode = node;
            ListNode secondNode = node.next;

            // 交换前后两个节点
            preNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // 移动下一个指针
            preNode = firstNode;
            node = firstNode.next;
        }

        return dummyNode.next;
    }


    /**
     * 使用递归的方式进行
     * time:O(n)
     * space:O(n)
     */
    public ListNode swapPairsRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode firstNode = head;
        ListNode secondNode = head.next;

        firstNode.next = swapPairsRecursive(secondNode.next);
        secondNode.next = firstNode;

        return secondNode;
    }

}
