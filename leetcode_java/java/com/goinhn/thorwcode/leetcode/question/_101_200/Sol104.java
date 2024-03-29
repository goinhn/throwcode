package com.goinhn.thorwcode.leetcode.question._101_200;

/**
 * 104.二叉树的最大深度
 *
 * @author goinhn
 * @date 2021/11/20
 */
public class Sol104 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * DFS
     * <p>
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {
        public int maxDepth(TreeNode root) {
            return maxSingle(root, 0);
        }

        private int maxSingle(TreeNode root, int deep) {
            if (root == null) {
                return deep;
            } else {
                return Math.max(maxSingle(root.left, deep + 1), maxSingle(root.right, deep + 1));
            }
        }
    }

}
