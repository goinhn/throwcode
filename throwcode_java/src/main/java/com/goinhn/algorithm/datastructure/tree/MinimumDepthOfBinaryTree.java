package com.goinhn.algorithm.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * <p>
 * leetcode 111
 * 二叉树的最小深度
 * <p>
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明：叶子节点是指没有子节点的节点。
 * </p>
 *
 * @author goinhn
 * @date 2020-12-25T21:02:34
 */
public class MinimumDepthOfBinaryTree {

    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 使用递归的方式
     *
     * @param root
     * @return
     */
    public int minDepthRecursion(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMin = minDepthRecursion(root.left);
        int rightMin = minDepthRecursion(root.right);

//        左子树或者右子树是否为空
        return (leftMin == 0 || rightMin == 0)
                ? leftMin + rightMin + 1
                : Math.min(leftMin, rightMin) + 1;
    }


    /**
     * 使用BFS的方式
     *
     * @param root
     * @return
     */
    public int minDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                root = queue.poll();
                if (root.left == null && root.right == null) {
                    return level;
                }
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
            }
        }

        return level;
    }


    /**
     * 使用DFS的方式
     *
     * @param root
     * @return
     */
    public int minDepthDFS(TreeNode root) {
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
