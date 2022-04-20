package com.goinhn.throwcode.codinginterviews.search_backtracking;

import java.util.Stack;

/**
 * 68II.二叉树的最近公共祖先
 *
 * @author goinhn
 * @date 2022/4/20
 */
public class Jz68II {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 利用栈存储节点路径
     * <p>
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            Stack<TreeNode> pStack = new Stack<>();
            Stack<TreeNode> qStack = new Stack<>();
            traverseInner(root, p, pStack);
            traverseInner(root, q, qStack);

            TreeNode parentNode = null;
            while (!pStack.isEmpty() && !qStack.isEmpty()) {
                if (pStack.peek() != qStack.peek()) {
                    break;
                } else {
                    parentNode = pStack.peek();
                }

                pStack.pop();
                qStack.pop();
            }
            return parentNode;
        }

        private boolean traverseInner(TreeNode root, TreeNode target, Stack<TreeNode> stack) {
            if (null == root) {
                return false;
            }

            boolean leftRes = traverseInner(root.left, target, stack);
            boolean rightRes = traverseInner(root.right, target, stack);

            if (leftRes || rightRes) {
                stack.push(root);
            }

            if (root == target) {
                stack.push(root);
                return true;
            } else {
                return leftRes || rightRes;
            }
        }
    }

    /**
     * 递归dfs
     * time:O(n)
     * space:O(n)
     */
    private static class Solution2 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) {
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return root;
        }
    }

}
