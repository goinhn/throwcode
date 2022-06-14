package com.goinhn.throwcode.codinginterviews.search_backtracking;

/**
 * 36.二叉搜索树与双向链表
 *
 * @author goinhn
 * @date 2022/6/14
 */
public class Jz36 {

    private static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    /**
     * 深度优先遍历
     * <p>
     * time:O(n^2)
     * space:O(n)
     */
    private static class Solution1 {

        private Node pre;

        private Node head;

        public Node treeToDoublyList(Node root) {
            if (root == null) {
                return null;
            }

            innerDfs(root);

            // 头尾节点指针处理
            head.left = pre;
            pre.right = head;

            return head;
        }

        private void innerDfs(Node root) {
            if (root == null) {
                return;
            }

            innerDfs(root.left);

            // 前置为空则为头节点
            if (pre == null) {
                head = root;
            } else {
                pre.right = root;
            }
            root.left = pre;
            pre = root;

            innerDfs(root.right);
        }

    }


}
