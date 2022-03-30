package com.goinhn.throwcode.codinginterviews.liked_list;

import java.util.HashMap;
import java.util.Map;

/**
 * 35.复杂链表的复制
 *
 * @author goinhn
 * @date 2020-12-14T20:11:03
 */
public class Jz35 {

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 递归+回溯
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {

        private static final Map<Node, Node> NODE_MAP = new HashMap<>();

        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
            if (!NODE_MAP.containsKey(head)) {
                Node newNode = new Node(head.val);
                NODE_MAP.put(head, newNode);
                newNode.next = copyRandomList(head.next);
                newNode.random = copyRandomList(head.random);
            }
            return NODE_MAP.get(head);
        }
    }

    /**
     * 哈希+遍历
     * time:O(n)
     * space:O(n)
     */
    private static class Solution2 {
        private static final Map<Node, Node> NODE_MAP = new HashMap<>();

        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
            // 遍历组合所有的对应关系
            Node nodeIndex = head;
            Node newNodePre = new Node(-1);
            while (nodeIndex != null) {
                newNodePre.next = new Node(nodeIndex.val);
                NODE_MAP.put(nodeIndex, newNodePre.next);
                nodeIndex = nodeIndex.next;
                newNodePre = newNodePre.next;
            }
            // 拼接剩下的random指向
            nodeIndex = head;
            Node newNodeIndex = NODE_MAP.get(nodeIndex);
            while (nodeIndex != null) {
                newNodeIndex.random = NODE_MAP.get(nodeIndex.random);
                nodeIndex = nodeIndex.next;
                newNodeIndex = newNodeIndex.next;
            }
            return NODE_MAP.get(head);
        }
    }

    /**
     * 指针切换，在原有的链表上进行操作
     * time:O(n)
     * space:O(1)
     */
    private static class Solution3 {
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }

            for (Node node = head; node != null; node = node.next.next) {
                Node newNode = new Node(node.val);
                newNode.next = node.next;
                node.next = newNode;
            }

            for (Node node = head; node != null; node = node.next.next) {
                node.next.random = node.random == null ? null : node.random.next;
            }

            Node newHead = head.next;
            for (Node node = head; node != null; node = node.next) {
                Node newNode = node.next;
                node.next = node.next.next;
                newNode.next = newNode.next == null ? null : newNode.next.next;
            }

            return newHead;
        }
    }
}
