package com.goinhn.leetcode._1_100;

/**
 * 100.相同的树
 *
 * @author goinhn
 * @date 2021/11/20
 */
public class Sol100 {

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
     * 深度优先搜索
     * <p>
     * time:O(min(m,n))
     * space:O(min(m,n))
     */
    private static class Solution1 {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            } else if (p == null || q == null) {
                return false;
            } else if (p.val != q.val) {
                return false;
            } else {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
        }
    }
}
