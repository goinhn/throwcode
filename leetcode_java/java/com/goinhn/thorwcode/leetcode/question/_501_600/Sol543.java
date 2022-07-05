package com.goinhn.thorwcode.leetcode.question._501_600;

/**
 * 543.二叉树的直径
 *
 * @author goinhn
 * @date 2022/7/5
 */
public class Sol543 {

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
     * dfs
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {

        private int maxDepth;

        public int diameterOfBinaryTree(TreeNode root) {
            maxDepth = 0;
            dfs(root);
            return maxDepth;
        }

        private int dfs(TreeNode node) {
            if (node == null) {
                return 0;
            }

            int l = dfs(node.left);
            int r = dfs(node.right);
            // 存储最大的直径值
            maxDepth = Math.max(l + r, maxDepth);
            // 存储最大的路径值
            return Math.max(l, r) + 1;
        }

    }

}
