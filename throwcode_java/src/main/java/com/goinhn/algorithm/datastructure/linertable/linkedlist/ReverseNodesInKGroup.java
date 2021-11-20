package com.goinhn.algorithm.datastructure.linertable.linkedlist;

/**
 * <p>
 * leetcode 25
 *
 * 给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
 * k是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例：
 * 给你这个链表：1->2->3->4->5
 * 当k= 2 时，应当返回: 2->1->4->3->5
 * 当k= 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明：
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * </p>
 *
 * @author goinhn
 * @date 2020-09-12T14:36:51
 */
public class ReverseNodesInKGroup {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 将中间需要翻转的链表段看成是一个节点，注意头尾节点进行交换
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode tail = head;

        while (head != null) {
            // 寻找是否有足够的节点进行翻转
            int i = 0;
            for (i = 0; i < k - 1 && tail.next != null; i++) {
                tail = tail.next;
            }

            if (i < k - 1) {
                // 没有足够的节点可以进行翻转的时候要注意将链表拼接上去
                prev.next = head;
                return dummy.next;
            }

            // 暂时保存下一个新链表段开始的节点
            ListNode tempNext = tail.next;
            reverse(head, tail);
            prev.next = tail;
            prev = head;
            head = tempNext;
            tail = tempNext;
        }

        return dummy.next;
    }

    /**
     * 当前所处的链表段进行反转，反转后头尾节点的位置不变，指向改变，返回下一段链表的开始节点
     *
     * @param head
     * @param tail
     * @return
     */
    public static void reverse(ListNode head, ListNode tail) {
        ListNode prev = null;
        ListNode cur = head;
        // 边界值需要单独保存一下
        ListNode border = tail.next;

        while (cur != border) {
            ListNode tempNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tempNode;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        node = reverseKGroup(node, 2);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}
