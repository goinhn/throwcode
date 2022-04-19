package com.goinhn.throwcode.codinginterviews.search_backtracking;

/**
 * 55I.二叉树的深度
 *
 * @author goinhn
 * @date 2022/4/19
 */
public class Jz55I {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 递归，dfs
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {
        private int maxDepth = 0;

        public int maxDepth(TreeNode root) {
            depthInner(root, 0);
            return maxDepth;
        }

        private void depthInner(TreeNode root, int depth) {
            if (root == null) {
                return;
            }
            depth++;
            maxDepth = Math.max(maxDepth, depth);
            depthInner(root.left, depth);
            depthInner(root.right, depth);
        }
    }

    /**
     * 递归，dfs
     * time:O(n)
     * space:O(n)
     */
    private static class Solution2 {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            } else {
                int leftDepth = maxDepth(root.left) + 1;
                int rightDepth = maxDepth(root.right) + 1;
                return Math.max(leftDepth, rightDepth);
            }
        }
    }
}
