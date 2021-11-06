package com.goinhn.leetcode._101_200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 * 使用深度优先遍历
 * </p>
 *
 * @author goinhn
 * @date 2020-09-30T09:09:02
 */
public class Solution_112_2 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

//      通过队列的结构来实现深度优先遍历
        Queue<TreeNode> queNode = new LinkedList<TreeNode>();
        Queue<Integer> queVal = new LinkedList<Integer>();
        queNode.offer(root);
        queVal.offer(root.val);
        while (!queNode.isEmpty()) {
            TreeNode now = queNode.poll();
            int temp = queVal.poll();
            if (now.left == null && now.right == null) {
                if (temp == sum) {
                    return true;
                }
                continue;
            }

            if (now.left != null) {
                queNode.offer(now.left);
                queVal.offer(now.left.val + temp);
            }

            if (now.right != null) {
                queNode.offer(now.right);
                queVal.offer(now.right.val + temp);
            }
        }

        return false;
    }

}
