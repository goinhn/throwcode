package com.goinhn.algorithm.datastructure.tree;

/**
 * <p>
 * leetcode 236
 * 二叉树的最近公共祖先
 * </p>
 *
 * @author goinhn
 * @date 2020-12-21T22:21:48
 */
public class LowestCommonAncestorOfABinaryTree {

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
