package com.goinhn.thorwcode.leetcode.question._101_200;

/**
 * @author goinhn
 * @date 2021/11/21
 */
public class Sol110 {

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
     * 自上向下递归
     * <p>
     * time:O(n^2)
     * space:O(n)
     */
    private static class Solution1 {
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            } else {
                return Math.abs(height(root.left) - height(root.right)) < 2
                        && isBalanced(root.left)
                        && isBalanced(root.right);
            }
        }

        private int height(TreeNode root) {
            if (root == null) {
                return 0;
            } else {
                return Math.max(height(root.left), height(root.right)) + 1;
            }
        }
    }

    /**
     * 自下向上递归
     * <p>
     * time:O(n)
     * space:O(n)
     */
    private static class Solution2 {
        public boolean isBalanced(TreeNode root) {
            return height(root) > -1;
        }

        private int height(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
                return -1;
            }

            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
