package com.goinhn.thorwcode.leetcode.question._101_200;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>
 * 二叉树层序遍历
 * <p>
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层序遍历结果：
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * <p>
 * 使用BFS进行层次打印
 *
 * time:O(n)
 * space:O(n)
 *
 * </p>
 *
 * @author goinhn
 * @date 2020-12-22T16:46:52
 */
public class Solution_102_1 {

    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> levelOrderBFS(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new LinkedList<>();
//            保持当前层的size大小
            int currentLevelSize = queue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                root = queue.poll();
                level.add(root.val);
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
            }
            result.add(level);
        }

        return result;
    }

}
