package com.goinhn.algorithm.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * <p>
 * leetcode 104
 * <p>
 * 二叉树的最大深度
 * <p>
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明:叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度3 。
 * </p>
 *
 * @author goinhn
 * @date 2020-12-25T18:01:12
 */
public class MaximumDepthOfBinaryTree {

    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    /**
     * 递归的方式
     *
     * @param root
     * @return
     */
    public int maxDepthRecursion(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepthRecursion(root.left), maxDepthRecursion(root.right));
    }

    /**
     * BFS的方式
     *
     * @param root
     * @return
     */
    public int maxDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()) {
            level++;
            int currentSize = queue.size();
            for(int i = 0; i < currentSize; i++) {
                root = queue.poll();
                if(root.left != null) {
                    queue.offer(root.left);
                }
                if(root.right != null) {
                    queue.offer(root.right);
                }
            }
        }

        return level;
    }


    /**
     * BFS的方式
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> levelStack = new Stack<>();
        stack.push(root);
        levelStack.push(1);
        int maxLevel = 0;
        while (!stack.isEmpty()) {
            root = stack.pop();
            int levelNow = levelStack.pop();
            maxLevel = Math.max(levelNow, maxLevel);

            if (root.right != null) {
                stack.push(root.right);
                levelStack.push(levelNow + 1);
            }

            if (root.left != null) {
                stack.push(root.left);
                levelStack.push(levelNow + 1);
            }
        }

        return maxLevel;
    }

}
