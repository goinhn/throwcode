package com.goinhn.thorwcode.leetcode.question._601_700;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 662.二叉树的最大宽度
 *
 * @author goinhn
 * @date 2022/8/5
 */
public class Sol662 {

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
     * 节点包装类
     */
    private static class WrapperTreeNode {
        TreeNode node;
        int position;

        public WrapperTreeNode(TreeNode node, int position) {
            this.node = node;
            this.position = position;
        }
    }

    /**
     * 广度优先搜索
     * 通过记录position来计算最大值
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {

        private int max;

        public int widthOfBinaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            }

            max = 0;
            Queue<WrapperTreeNode> queue = new LinkedList<>();
            WrapperTreeNode wrapperRoot = new WrapperTreeNode(root, 1);
            queue.offer(wrapperRoot);
            while (!queue.isEmpty()) {
                int size = queue.size();
                WrapperTreeNode firstNode = null;
                WrapperTreeNode lastNode = null;
                for (int i = 0; i < size; i++) {
                    WrapperTreeNode tempNode = queue.poll();

                    if (i == 0) {
                        firstNode = tempNode;
                    }

                    if (i == size - 1) {
                        lastNode = tempNode;
                    }


                    if (tempNode.node.left != null) {
                        queue.offer(new WrapperTreeNode(tempNode.node.left, tempNode.position * 2));
                    }

                    if (tempNode.node.right != null) {
                        queue.offer(new WrapperTreeNode(tempNode.node.right, tempNode.position * 2 + 1));
                    }
                }

                max = Math.max(max, lastNode.position - firstNode.position + 1);
            }

            return max;
        }

    }

}
