package com.goinhn.throwcode.codinginterviews.search_backtracking;

/**
 * 54.二叉树的第k大节点
 *
 * @author goinhn
 * @date 2022/4/13
 */
public class Jz54 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * dfs中序遍历
     * time:O(logn)
     * space:O(logn)
     */
    private static class Solution1 {
        private int result = 0;
        private int k = 0;

        public int kthLargest(TreeNode root, int k) {
            this.k = k;
            traversalInner(root);
            return result;
        }

        private void traversalInner(TreeNode root) {
            if (root == null) {
                return;
            }

            traversalInner(root.right);
            if (--k == 0) {
                result = root.val;
                return;
            }
            traversalInner(root.left);
        }
    }
}

