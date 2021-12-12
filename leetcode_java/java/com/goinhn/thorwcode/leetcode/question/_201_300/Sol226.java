package com.goinhn.thorwcode.leetcode.question._201_300;

/**
 * @author goinhn
 * @date 2021/12/12
 */
public class Sol226 {

    public static class TreeNode {
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
     * 深度优先搜索
     * <p>
     * time:O(logn)
     * space:O(logn)
     */
    private static class Solution1 {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }

            TreeNode temp = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(temp);
            return root;
        }
    }
}
