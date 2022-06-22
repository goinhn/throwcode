package com.goinhn.thorwcode.leetcode.question._501_600;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 513.找树左下角的值
 *
 * @author goinhn
 * @date 2022/6/22
 */
public class Sol513 {

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
     * dfs
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {

        private static class NodePair {
            int val;
            int level;

            NodePair() {
            }

            NodePair(int val, int level) {
                this.val = val;
                this.level = level;
            }
        }

        public int findBottomLeftValue(TreeNode root) {
            NodePair deepestLeftNodePair = dfs(root, 1);
            return deepestLeftNodePair.val;
        }

        private NodePair dfs(TreeNode node, int level) {
            if (node == null) {
                return null;
            }

            if (node.left == null && node.right == null) {
                return new NodePair(node.val, level);
            }

            NodePair leftPair = dfs(node.left, level + 1);
            NodePair rightPair = dfs(node.right, level + 1);

            if (leftPair == null) {
                return rightPair;
            }

            if (rightPair == null) {
                return leftPair;
            }

            // 按照最左的原则，放置最左侧的原则
            if (leftPair.level >= rightPair.level) {
                return leftPair;
            } else {
                return rightPair;
            }
        }

    }

    /**
     * dfs
     * time:O(n)
     * space:O(n)
     */
    private static class Solution2 {

        private int deepestLeftVal;

        private int deepestLevel;

        public int findBottomLeftValue(TreeNode root) {
            deepestLeftVal = -1;
            deepestLevel = 0;

            dfs(root, 1);

            return deepestLeftVal;
        }

        private void dfs(TreeNode node, int level) {
            if (node == null) {
                return;
            }

            // 按照最左的原则，先入为主
            if (deepestLevel < level) {
                deepestLevel = level;
                deepestLeftVal = node.val;
            }

            level++;
            dfs(node.left, level);
            dfs(node.right, level);
        }

    }

    /**
     * bfs
     * time:O(n)
     * space:O(n)
     */
    private static class Solution3 {

        public int findBottomLeftValue(TreeNode root) {
            if (root == null) {
                return -1;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int deepestLeftVal = -1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode tempNode = queue.poll();
                    if (i == 0) {
                        deepestLeftVal = tempNode.val;
                    }

                    if (tempNode.left != null) {
                        queue.offer(tempNode.left);
                    }
                    if (tempNode.right != null) {
                        queue.offer(tempNode.right);
                    }
                }
            }

            return deepestLeftVal;
        }

    }

}
