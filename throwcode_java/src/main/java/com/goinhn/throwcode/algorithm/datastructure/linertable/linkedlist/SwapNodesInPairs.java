package com.goinhn.throwcode.algorithm.datastructure.linertable.linkedlist;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表
 * leetcode 24
 *
 * @author goinhn
 * @date 2020-09-12T01:28:46
 */
public class SwapNodesInPairs {

    public static class Node {
        int val;
        Node next;

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 指针移动进行交换
     * time:O(n)
     * space:O(1)
     */
    public Node swapPairs(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node dummyNode = new Node(-1, head);
        Node preNode = dummyNode;
        Node node = head;
        while (node != null && node.next != null) {
            // 设置前后两个节点
            Node firstNode = node;
            Node secondNode = node.next;

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
    public Node swapPairsRecursive(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node firstNode = head;
        Node secondNode = head.next;

        firstNode.next = swapPairsRecursive(secondNode.next);
        secondNode.next = firstNode;

        return secondNode;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);
        Node node5 = new Node(5, null);
        Node node6 = new Node(6, null);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        Node root = new SwapNodesInPairs().swapPairs(node1);
        while(root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }

}
