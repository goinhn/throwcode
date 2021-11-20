package com.goinhn.sworddirectoffer;

/**
 * <p>
 * 二叉树的镜像
 * <p>
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * <p>
 * 二叉树的镜像定义：源二叉树
 * 8
 * /  \
 * 6   10
 * / \  / \
 * 5  7 9 11
 * 镜像二叉树
 * 8
 * /  \
 * 10   6
 * / \  / \
 * 11 9 7  5
 * </p>
 *
 * @author goinhn
 * @date 2020-12-09T17:10:11
 */
public class JZ18 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void mirror(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;


//        最后两个的if判断是为了减少入栈的层次
        if(root.left != null) {
            mirror(root.left);
        }

        if(root.right != null) {
            mirror(root.right);
        }
    }
}
