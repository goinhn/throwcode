package com.goinhn.sworddirectoffer;

/**
 * <p>
 * 树的子结构
 * <p>
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * </p>
 *
 * @author goinhn
 * @date 2020-12-09T16:30:03
 */
public class JZ17 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        TreeNode subRoot = new TreeNode(3);
        subRoot.left = new TreeNode(6);
        subRoot.right = new TreeNode(7);

        System.out.println(new JZ17().hasSubtree(root, subRoot));
    }


    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }

        boolean result = false;
        if (root1.val == root2.val) {
            result = isSubTree(root1, root2);
        }

        if (!result) {
            result = hasSubtree(root1.left, root2);
        }

        if (!result) {
            result = hasSubtree(root1.right, root2);
        }

        return result;
    }

    public boolean isSubTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }

        if (root1 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
    }

}
