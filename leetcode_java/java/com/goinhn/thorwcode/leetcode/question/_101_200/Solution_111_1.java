package com.goinhn.thorwcode.leetcode.question._101_200;

/**
 * <p>
 * 二叉树的最小深度
 * <p>
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明：叶子节点是指没有子节点的节点。
 * <p>
 * 使用递归的方式
 * </p>
 *
 * @author goinhn
 * @date 2020-12-25T21:02:34
 */
public class Solution_111_1 {

    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMin = minDepth(root.left);
        int rightMin = minDepth(root.right);

//        左子树或者右子树是否为空
        return (leftMin == 0 || rightMin == 0)
                ? leftMin + rightMin + 1
                : Math.min(leftMin, rightMin) + 1;
    }
}
