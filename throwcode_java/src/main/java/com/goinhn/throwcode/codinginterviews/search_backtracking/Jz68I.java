package com.goinhn.throwcode.codinginterviews.search_backtracking;

/**
 * 68I.二叉树搜索树的最近公共祖先
 *
 * @author goinhn
 * @date 2022/4/20
 */
public class Jz68I {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 利用二叉搜索树特性
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || p == null || q == null) {
                return null;
            }

            while (true) {
                if (root == null) {
                    return null;
                }
                if (root.val > p.val && root.val > q.val) {
                    root = root.left;
                } else if (root.val < p.val && root.val < q.val) {
                    root = root.right;
                } else {
                    return root;
                }
            }
        }
    }

}
