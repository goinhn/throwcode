package com.goinhn.algorithm.linkedalg;


/**
 * <p>
 * 链表中倒数第k个节点
 * <p>
 * 输入一个链表，输出该链表中倒数第k个结点
 * <p>
 * 首先两个节点/指针，一个节点 node1 先开始跑，指针 node1 跑到 k-1 个节点后，另一个节点 node2 开始跑，当 node1 跑到最后时，node2 所指的节点就是倒数第k个节点也就是正数第(L-K+1)个节点。
 * </p>
 *
 * @author goinhn
 * @date 2020-12-03T22:31:02
 */
public class FindToTail {

    public static void main(String[] args) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        int count = 1;
        while (count < 10) {
            head.next = new ListNode(count++);
            head = head.next;
        }

        ListNode result = new FindToTail().findToTail(dummy.next, 2);
        System.out.println(result.val);
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode findToTail(ListNode head, int k) {
//        逻辑判断
        if (head == null || k < 1) {
            return null;
        }

        ListNode kNode = head;
        ListNode result = head;

//        第一个指针先跑
        for (int i = 0; i < k - 1; i++) {
            if (kNode.next != null) {
                kNode = kNode.next;
            } else {
                return null;
            }
        }

        while (kNode.next != null) {
            result = result.next;
            kNode = kNode.next;
        }

        return result;
    }

    public ListNode findToTailOfficial(ListNode head, int k) {
        if (head == null || k < 1) {
            return null;
        }

        ListNode kNode = head, result = head;

        int kTemp = k;
        int count = 0;
        while (kNode != null) {
            kNode = kNode.next;
            count++;
            if (kTemp < 1) {
                result = result.next;
            }
            kTemp--;
        }

        if (count < k) {
            return null;
        }

        return result;
    }

}
