package com.goinhn.leetcode._201_300._231_240;

/**
 * <p>
 * 二叉树的最近公共祖先
 * <p>
 * 递归的方式
 *
 * </p>
 *
 * @author goinhn
 * @date 2020-12-20T15:25:47
 */
public class Solution_236_1 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        如果当前节点为空，或者节点和p或者q重合，那么就直接返回该节点即可
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

//        如果左边和右边都不为空的话，那么当前的根节点就是为最近的公共祖先节点
        return left == null ? right : right == null ? left : root;
    }

}
