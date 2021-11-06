package com.goinhn.leetcode._101_200;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * <p>
 * 二叉树的最小深度
 * <p>
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明：叶子节点是指没有子节点的节点。
 * <p>
 * 使用BFS
 * </p>
 *
 * @author goinhn
 * @date 2020-12-25T21:02:34
 */
public class Solution_111_3 {

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

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> levelStack = new Stack<>();
        stack.push(root);
        levelStack.push(1);
        int minLevel = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            root = stack.pop();
            int levelNow = levelStack.pop();
            if (root.left == null && root.right == null) {
                minLevel = Math.min(levelNow, minLevel);
            }

            if (root.right != null) {
                stack.push(root.right);
                levelStack.push(levelNow + 1);
            }

            if (root.left != null) {
                stack.push(root.left);
                levelStack.push(levelNow + 1);
            }
        }

        return minLevel;
    }


}
