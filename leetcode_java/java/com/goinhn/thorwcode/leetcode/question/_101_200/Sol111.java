package com.goinhn.thorwcode.leetcode.question._101_200;

/**
 * 111.二叉树的最小深度
 *
 * @author goinhn
 * @date 2021/11/21
 */
public class Sol111 {

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
     * 广度优先搜索
     * <p>
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (root.left == null && root.right == null) {
                return 1;
            }
            int ans = Integer.MAX_VALUE;
            if (root.left != null) {
                ans = Math.min(minDepth(root.left), ans);
            }
            if (root.right != null) {
                ans = Math.min(minDepth(root.right), ans);
            }
            return ans + 1;
        }
    }
}
