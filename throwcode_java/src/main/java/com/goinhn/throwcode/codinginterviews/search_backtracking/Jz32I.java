package com.goinhn.throwcode.codinginterviews.search_backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 32I.从上往下打印二叉树
 *
 * @author goinhn
 * @date 2020-12-10T00:39:04
 */
public class Jz32I {

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 队列
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {
        public int[] levelOrder(TreeNode root) {
            if (root == null) {
                return new int[0];
            }
            Queue<TreeNode> nodeList = new LinkedList<>();
            nodeList.add(root);
            List<Integer> valList = new ArrayList<>();
            while (!nodeList.isEmpty()) {
                TreeNode tempNode = nodeList.poll();
                valList.add(tempNode.val);
                if (tempNode.left != null) {
                    nodeList.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    nodeList.add(tempNode.right);
                }
            }

            int[] result = new int[valList.size()];
            for (int i = 0; i < valList.size(); i++) {
                result[i] = valList.get(i);
            }
            return result;
        }
    }

}
