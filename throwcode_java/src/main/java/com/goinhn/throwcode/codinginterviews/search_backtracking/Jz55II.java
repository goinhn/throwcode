package com.goinhn.throwcode.codinginterviews.search_backtracking;

/**
 * 55II.平衡二叉树
 *
 * @author goinhn
 * @date 2022/4/19
 */
public class Jz55II {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 递归，dfs，自下向上
     * <p>
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {
        public boolean isBalanced(TreeNode root) {
            return isBalancedInner(root, 0) > -1;
        }

        private int isBalancedInner(TreeNode root, int depth) {
            if (root == null) {
                return depth;
            }
            depth++;
            int leftDepth = isBalancedInner(root.left, depth);
            int rightDepth = isBalancedInner(root.right, depth);
            if (leftDepth == -1 || rightDepth == -1 || Math.abs(leftDepth - rightDepth) > 1) {
                return -1;
            }
            return Math.max(leftDepth, rightDepth);
        }
    }

    /**
     * 递归，dfs，自上向下
     * time:O(n^2)
     * space:O(n)
     */
    private static class Solution2 {
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            } else {
                return Math.max(isBalancedInner(root.left), isBalancedInner(root.right)) < 2
                        && isBalanced(root.left)
                        && isBalanced(root.right);
            }
        }

        private int isBalancedInner(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(isBalancedInner(root.left), isBalancedInner(root.right)) + 1;
        }
    }
}
