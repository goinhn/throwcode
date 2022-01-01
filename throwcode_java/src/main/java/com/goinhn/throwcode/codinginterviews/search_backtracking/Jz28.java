package com.goinhn.throwcode.codinginterviews.search_backtracking;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 28.对称的二叉树
 *
 * @author goinhn
 * @date 2021/12/31
 */
public class Jz28 {

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * DFS
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }

            return isSymmetricHelper(root.left, root.right);
        }

        private boolean isSymmetricHelper(TreeNode leftNode, TreeNode rightNode) {
            if (leftNode == null && rightNode == null) {
                return true;
            }
            if (leftNode == null || rightNode == null) {
                return false;
            }
            return leftNode.val == rightNode.val
                    && isSymmetricHelper(leftNode.left, rightNode.right)
                    && isSymmetricHelper(leftNode.right, rightNode.left);
        }
    }

    /**
     * BFS
     * time:O(n)
     * space:O(n)
     */
    private static class Solution2 {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }

            Queue<TreeNode> nodeQueue = new LinkedList<>();
            nodeQueue.offer(root.left);
            nodeQueue.offer(root.right);
            while (!nodeQueue.isEmpty()) {
                for (int i = nodeQueue.size(); i > 0; i -= 2) {
                    TreeNode leftNode = nodeQueue.poll();
                    TreeNode rightNode = nodeQueue.poll();
                    if (leftNode == null && rightNode == null) {
                        continue;
                    }
                    if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                        return false;
                    }
                    nodeQueue.offer(leftNode.left);
                    nodeQueue.offer(rightNode.right);
                    nodeQueue.offer(leftNode.right);
                    nodeQueue.offer(rightNode.left);
                }
            }
            return true;
        }
    }
}

