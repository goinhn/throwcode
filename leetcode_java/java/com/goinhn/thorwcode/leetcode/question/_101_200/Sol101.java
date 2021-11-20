package com.goinhn.thorwcode.leetcode.question._101_200;

/**
 * 101.对称二叉树
 *
 * @author goinhn
 * @date 2021/11/20
 */
public class Sol101 {

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
     * 广度优先搜索，转换为两个相同的树问题
     * <p>
     * time:O(min(m,n))
     * space:O(min(m,n))
     */
    private static class Solution1 {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return isSame(root.left, root.right);
        }

        private boolean isSame(TreeNode leftTree, TreeNode rightTree) {
            if (leftTree == null && rightTree == null) {
                return true;
            } else if (leftTree == null || rightTree == null) {
                return false;
            } else if (leftTree.val != rightTree.val) {
                return false;
            } else {
                return isSame(leftTree.left, rightTree.right) && isSame(leftTree.right, rightTree.left);
            }
        }
    }
}
