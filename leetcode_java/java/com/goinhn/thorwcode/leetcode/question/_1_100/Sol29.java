package com.goinhn.thorwcode.leetcode.question._1_100;

/**
 * @author goinhn
 * @date 2022/6/18
 */
public class Sol29 {

    private static class Node {

        public int val;

        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }

    }

    /**
     * 维护链表中的最大值和最小值来判断
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {

        public Node insert(Node head, int insertVal) {
            if (head == null) {
                Node node = new Node(insertVal);
                node.next = node;
                return node;
            }

            Node node = head;
            Node loopNode = node;
            Node minNode = null;
            Node maxNode = null;
            while (maxNode == null || node != loopNode) {
                if ((maxNode == null && loopNode.val >= loopNode.next.val)
                        || loopNode.val > loopNode.next.val) {
                    maxNode = loopNode;
                }
                loopNode = loopNode.next;
            }
            minNode = maxNode.next;

            if (minNode.val >= insertVal || maxNode.val <= insertVal) {
                maxNode.next = new Node(insertVal, minNode);
                return head;
            }

            while (node.val > insertVal || node.next.val < insertVal) {
                node = node.next;
            }
            node.next = new Node(insertVal, node.next);

            return head;
        }

    }

    /**
     * 循环遍历
     * time:O(n)
     * space:O(1)
     */
    private static class Solution2 {

        public Node insert(Node head, int insertVal) {
            // 不存在循环链表则直接构建
            if (head == null) {
                head = new Node(insertVal);
                head.next = head;
                return head;
            }

            // 存在一个节点则直接插入
            if (head.next == head) {
                head.next = new Node(insertVal, head);
                return head;
            }

            Node node = head;
            Node maxNode = head;
            do {
                // 存在中间的位置则直接插入返回
                if (node.val <= insertVal && node.next.val >= insertVal) {
                    node.next = new Node(insertVal, node.next);
                    return head;
                }

                // 寻找最大的节点，找到了最大的节点则最小的节点则为后一个节点
                if (node.val >= maxNode.val) {
                    maxNode = node;
                }

                node = node.next;
            } while (node != head);

            // 不存在中间的位置则直接插入到最大节点和最小节点之间
            maxNode.next = new Node(insertVal, maxNode.next);

            return head;
        }

    }

}
