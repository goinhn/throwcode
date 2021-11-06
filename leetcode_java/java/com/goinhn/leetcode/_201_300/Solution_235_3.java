package com.goinhn.leetcode._201_300;

/**
 * <p>
 * 二叉搜索树的最近公共祖先
 * <p>
 * 递归的方式
 * </p>
 *
 * @author goinhn
 * @date 2020-12-20T15:25:47
 */
public class Solution_235_3 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    /**
     * 递归返回搜索二叉树的节点
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }

}
