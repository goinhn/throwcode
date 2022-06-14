package com.goinhn.throwcode.codinginterviews.search_backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 34.二叉树中和为某一值的路径
 *
 * @author goinhn
 * @date 2022/6/14
 */
public class Jz34 {

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
     * 深度优先遍历
     * <p>
     * time:O(n^2)
     * space:O(n)
     */
    private static class Solution1 {

        private final List<List<Integer>> paths = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int target) {
            innerDfs(root, target, 0, new ArrayList<>());
            return paths;
        }

        private void innerDfs(TreeNode node, int target, int nowSum, List<Integer> nowPath) {
            if (node == null) {
                return;
            }

            nowSum += node.val;
            List<Integer> innerPath = new ArrayList<>(nowPath);
            innerPath.add(node.val);

            if (nowSum == target && node.left == null && node.right == null) {
                paths.add(innerPath);
            } else {
                innerDfs(node.left, target, nowSum, innerPath);
                innerDfs(node.right, target, nowSum, innerPath);
            }

        }

    }

    /**
     * 广度优先遍历
     * <p>
     * time:O(n^2)
     * space:O(n)
     */
    private static class Solution2 {

        /**
         * 节点信息
         */
        private static class NodeInfo {

            private TreeNode node;

            private int sum;

            private List<Integer> path;

            public NodeInfo(TreeNode node, int sum, List<Integer> path) {
                this.node = node;
                this.sum = sum;
                this.path = path;
            }

            public TreeNode getNode() {
                return node;
            }

            public void setNode(TreeNode node) {
                this.node = node;
            }

            public int getSum() {
                return sum;
            }

            public void setSum(int sum) {
                this.sum = sum;
            }

            public List<Integer> getPath() {
                return path;
            }

            public void setPath(List<Integer> path) {
                this.path = path;
            }
        }

        public List<List<Integer>> pathSum(TreeNode root, int target) {
            List<List<Integer>> paths = new ArrayList<>();
            Queue<NodeInfo> queue = new LinkedList<>();
            NodeInfo rootInfo = new NodeInfo(root, 0, new ArrayList<>());
            queue.offer(rootInfo);
            while (!queue.isEmpty()) {
                NodeInfo nowNodeInfo = queue.poll();
                if (nowNodeInfo.getNode() == null) {
                    continue;
                }

                nowNodeInfo.setSum(nowNodeInfo.getSum() + nowNodeInfo.getNode().val);
                List<Integer> innerPath = new ArrayList<>(nowNodeInfo.getPath());
                innerPath.add(nowNodeInfo.getNode().val);
                if (nowNodeInfo.getSum() == target
                        && nowNodeInfo.getNode().left == null
                        && nowNodeInfo.getNode().right == null) {
                    paths.add(innerPath);
                } else {
                    queue.offer(new NodeInfo(nowNodeInfo.getNode().left, nowNodeInfo.getSum(), innerPath));
                    queue.offer(new NodeInfo(nowNodeInfo.getNode().right, nowNodeInfo.getSum(), innerPath));
                }
            }

            return paths;
        }

    }

}
