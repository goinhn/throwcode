package com.goinhn.leetcode._101_200._101_110;

import java.util.LinkedList;
import java.util.Queue;

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
public class Solution_111_2 {

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
}
