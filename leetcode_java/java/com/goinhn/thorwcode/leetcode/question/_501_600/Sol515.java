package com.goinhn.thorwcode.leetcode.question._501_600;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 515.在每个树行中找最大值
 *
 * @author goinhn
 * @date 2022/6/24
 */
public class Sol515 {

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

        public List<Integer> largestValues(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            List<Integer> maxList = new LinkedList<>();
            while (!queue.isEmpty()) {
                int size = queue.size();
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < size; i++) {
                    TreeNode tempNode = queue.poll();
                    max = Math.max(max, tempNode.val);
                    if (tempNode.left != null) {
                        queue.offer(tempNode.left);
                    }
                    if (tempNode.right != null) {
                        queue.offer(tempNode.right);
                    }
                }
                maxList.add(max);
            }

            return maxList;
        }

    }

    /**
     * dfs
     * time:O(n)
     * space:O(n)
     */
    private static class Solution2 {

        private List<Integer> resList;

        public List<Integer> largestValues(TreeNode root) {
            resList = new ArrayList();

            dfs(root, 0);

            return resList;
        }

        private void dfs(TreeNode node, int depth) {
            if (node == null) {
                return;
            }

            if (resList.size() == depth) {
                resList.add(node.val);
            } else {
                resList.set(depth, Math.max(resList.get(depth), node.val));
            }

            depth++;
            dfs(node.left, depth);
            dfs(node.right, depth);
        }

    }

}
