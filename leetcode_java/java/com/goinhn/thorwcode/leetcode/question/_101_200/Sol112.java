package com.goinhn.thorwcode.leetcode.question._101_200;

/**
 * 112.路径总和
 *
 * @author goinhn
 * @date 2021/11/22
 */
public class Sol112 {

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
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return false;
            }
            if (root.left == null && root.right == null) {
                return root.val == targetSum;
            }
            return hasPathSum(root.left, targetSum - root.val)
                    || hasPathSum(root.right, targetSum - root.val);
        }
    }
}
