package com.goinhn.throwcode.codinginterviews.search_backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 32III.从上往下打印二叉树
 *
 * @author goinhn
 * @date 2021/12/28
 */
public class Jz32III {

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
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }

            Deque<TreeNode> nodeQueue = new LinkedList<>();
            List<List<Integer>> resultList = new ArrayList<>();
            nodeQueue.add(root);
            while (!nodeQueue.isEmpty()) {
                LinkedList<Integer> valList = new LinkedList<>();
                for (int i = nodeQueue.size(); i > 0; i--) {
                    TreeNode tempNode = nodeQueue.poll();
                    if (resultList.size() % 2 == 0) {
                        valList.addLast(tempNode.val);
                    } else {
                        valList.addFirst(tempNode.val);
                    }
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

