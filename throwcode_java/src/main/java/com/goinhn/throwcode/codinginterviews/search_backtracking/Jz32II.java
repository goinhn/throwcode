package com.goinhn.throwcode.codinginterviews.search_backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 32II.从上往下打印二叉树
 *
 * @author goinhn
 * @date 2021/12/28
 */
public class Jz32II {

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
    private static class Solution2 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }

            Queue<TreeNode> nodeQueue = new LinkedList<>();
            List<List<Integer>> resultList = new ArrayList<>();
            nodeQueue.add(root);
            while (!nodeQueue.isEmpty()) {
                List<Integer> valList = new ArrayList<>();
                for (int i = nodeQueue.size(); i > 0; i--) {
                    TreeNode tempNode = nodeQueue.poll();
                    valList.add(tempNode.val);
                    if (tempNode.left != null) {
                        nodeQueue.add(tempNode.left);
                    }
                    if (tempNode.right != null) {
                        nodeQueue.add(tempNode.right);
                    }
                }
                resultList.add(valList);
            }

            return resultList;
        }
    }
}

