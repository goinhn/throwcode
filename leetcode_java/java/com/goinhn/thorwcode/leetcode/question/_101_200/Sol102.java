package com.goinhn.thorwcode.leetcode.question._101_200;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102.二叉树的层序遍历
 *
 * @author goinhn
 * @date 2022/6/21
 */
public class Sol102 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    /**
     * bfs
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {

        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            List<List<Integer>> resList = new LinkedList<>();
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                List<Integer> levelList = new LinkedList<>();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode tempNode = queue.poll();
                    levelList.add(tempNode.val);
                    if (tempNode.left != null) {
                        queue.offer(tempNode.left);
                    }
                    if (tempNode.right != null) {
                        queue.offer(tempNode.right);
                    }
                }
                resList.add(levelList);
            }

            return resList;
        }

    }

    /**
     * dfs
     * time:O(n)
     * space:O(n)
     */
    private static class Solution2 {

        private List<List<Integer>> resList;

        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }

            resList = new LinkedList<>();

            dfs(root, 0);

            return resList;
        }


        /**
         * 递归辅助函函数
         */
        public void dfs(TreeNode root, int level) {
            if (root == null) {
                return;
            }

            if (resList.size() < level + 1) {
                resList.add(new LinkedList<>());
            }

            resList.get(level).add(root.val);

            dfs(root.left, level + 1);
            dfs(root.right, level + 1);
        }

    }

}
