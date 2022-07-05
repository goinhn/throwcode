package com.goinhn.thorwcode.leetcode.question._601_700;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 617.合并二叉树
 *
 * @author goinhn
 * @date 2022/7/5
 */
public class Sol617 {

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
     * time:O(min(m,n))
     * space:O(min(m,n))
     */
    private static class Solution1 {

        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            return dfs(root1, root2);
        }

        private TreeNode dfs(TreeNode node1, TreeNode node2) {
            if (node1 == null) {
                return node2;
            }
            if (node2 == null) {
                return node1;
            }

            TreeNode node = new TreeNode(node1.val + node2.val);
            node.left = dfs(node1.left, node2.left);
            node.right = dfs(node1.right, node2.right);
            return node;
        }

    }

    /**
     * bfs
     * time:O(min(m,n))
     * space:O(min(m,n))
     */
    private static class Solution2 {

        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null) {
                return root2;
            }
            if (root2 == null) {
                return root1;
            }

            TreeNode merged = new TreeNode(root1.val + root2.val);
            Queue<TreeNode> queue = new LinkedList<>();
            Queue<TreeNode> queue1 = new LinkedList<>();
            Queue<TreeNode> queue2 = new LinkedList<>();
            queue.offer(merged);
            queue1.offer(root1);
            queue2.offer(root2);
            while (!queue1.isEmpty() && !queue2.isEmpty()) {
                TreeNode node = queue.poll();
                TreeNode node1 = queue1.poll();
                TreeNode node2 = queue2.poll();
                TreeNode left1 = node1.left;
                TreeNode left2 = node2.left;
                TreeNode right1 = node1.right;
                TreeNode right2 = node2.right;
                if (left1 != null || left2 != null) {
                    if (left1 != null && left2 != null) {
                        TreeNode left = new TreeNode(left1.val + left2.val);
                        node.left = left;
                        queue.offer(left);
                        queue1.offer(left1);
                        queue2.offer(left2);

                    } else if (left1 != null) {
                        node.left = left1;

                    } else {
                        node.left = left2;
                    }
                }

                if (right1 != null || right2 != null) {
                    if (right1 != null && right2 != null) {
                        TreeNode right = new TreeNode(right1.val + right2.val);
                        node.right = right;
                        queue.offer(right);
                        queue1.offer(right1);
                        queue2.offer(right2);

                    } else if (right1 != null) {
                        node.right = right1;

                    } else {
                        node.right = right2;
                    }
                }
            }

            return merged;
        }

    }

}
