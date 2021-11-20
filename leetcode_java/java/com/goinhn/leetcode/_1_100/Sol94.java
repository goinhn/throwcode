package com.goinhn.leetcode._1_100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author goinhn
 * @date 2021/11/20
 */
public class Sol94 {

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
     * 递归实现
     * <p>
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            setVal(root, list);
            return list;
        }

        private void setVal(TreeNode root, List<Integer> list) {
            if (root != null) {
                setVal(root.left, list);
                list.add(root.val);
                setVal(root.right, list);
            }
        }
    }

    /**
     * 利用栈进行迭代
     * <p>
     * time:O(n)
     * space:O(n)
     */
    private static class Solution2 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.empty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
            return list;
        }
    }
}
