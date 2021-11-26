package com.goinhn.thorwcode.leetcode.question._101_200;

import java.util.ArrayList;
import java.util.List;

/**
 * 145.二叉树的后序遍历
 *
 * @author goinhn
 * @date 2021/11/26
 */
public class Sol145 {

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
     * 递归
     * <p>
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            traverseHelper(root, list);
            return list;
        }

        public void traverseHelper(TreeNode root, List<Integer> list) {
            if (root != null) {
                traverseHelper(root.left, list);
                traverseHelper(root.right, list);
                list.add(root.val);
            }
        }
    }
}
