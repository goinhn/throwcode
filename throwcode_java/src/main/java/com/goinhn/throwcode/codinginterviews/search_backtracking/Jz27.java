package com.goinhn.throwcode.codinginterviews.search_backtracking;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 27.二叉树的镜像
 *
 * @author goinhn
 * @date 2020-12-09T17:10:11
 */
public class Jz27 {

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
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null || root.left == null && root.right == null) {
                return root;
            }

            TreeNode tempNode = root.left;
            root.left = root.right;
            root.right = tempNode;

            if (root.left != null) {
                mirrorTree(root.left);
            }
            if (root.right != null) {
                mirrorTree(root.right);
            }
            return root;
        }
    }

    /**
     * BFS
     * time:O(n)
     * space:O(n)
     */
    private static class Solution2 {
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null || root.left == null && root.right == null) {
                return root;
            }

            Queue<TreeNode> nodeQueue = new LinkedList<>();
            nodeQueue.offer(root);
            while (!nodeQueue.isEmpty()) {
                TreeNode tempNode = nodeQueue.poll();
                TreeNode changeNode = tempNode.right;
                tempNode.right = tempNode.left;
                tempNode.left = changeNode;

                if (tempNode.left != null) {
                    nodeQueue.offer(tempNode.left);
                }
                if (tempNode.right != null) {
                    nodeQueue.offer(tempNode.right);
                }
            }
            return root;
        }
    }
}
