package com.goinhn.thorwcode.leetcode.question._601_700;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 653.两数之和IV-输入BST
 *
 * @author goinhn
 * @date 2022/4/20
 */
public class Sol653 {

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
     * 深度优先遍历 + 哈希表
     * <p>
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {
        private static final Set<Integer> NUM_SET = new HashSet<>();

        public boolean findTarget(TreeNode root, int k) {
            if (null == root) {
                return false;
            }
            if (NUM_SET.contains(k - root.val)) {
                return true;
            }
            NUM_SET.add(root.val);

            return findTarget(root.left, k) || findTarget(root.right, k);
        }
    }

    /**
     * 广度优先遍历 + 哈希表
     * <p>
     * time:O(n)
     * space:O(n)
     */
    private static class Solution2 {
        private static final Set<Integer> NUM_SET = new HashSet<>();
        private static final Queue<TreeNode> NODE_QUEUE = new LinkedList<>();

        public boolean findTarget(TreeNode root, int k) {
            NODE_QUEUE.offer(root);
            while (!NODE_QUEUE.isEmpty()) {
                root = NODE_QUEUE.poll();

                if (NUM_SET.contains(k - root.val)) {
                    return true;
                }
                NUM_SET.add(root.val);

                if (root.left != null) {
                    NODE_QUEUE.add(root.left);
                }
                if (root.right != null) {
                    NODE_QUEUE.add(root.right);
                }
            }
            return false;
        }
    }

    /**
     * 中序遍历 + 双指针
     * <p>
     * time:O(n)
     * space:O(n)
     */
    private static class Solution3 {
        public boolean findTarget(TreeNode root, int k) {
            TreeNode left = root;
            TreeNode right = root;
            Deque<TreeNode> leftStack = new ArrayDeque<>();
            Deque<TreeNode> rightStack = new ArrayDeque<>();

            // 找到最左侧最小值
            leftStack.push(left);
            while (left.left != null) {
                leftStack.push(left.left);
                left = left.left;
            }

            // 找到最右侧最大值
            rightStack.push(right);
            while (right.right != null) {
                rightStack.push(right.right);
                right = right.right;
            }

            // 双指针向中间移动
            while (left != right) {
                if (left.val + right.val == k) {
                    return true;
                }
                if (left.val + right.val < k) {
                    left = getLeft(leftStack);
                } else {
                    right = getRight(rightStack);
                }
            }

            return false;
        }

        private TreeNode getLeft(Deque<TreeNode> stack) {
            TreeNode root = stack.pop();
            TreeNode node = root.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            return root;
        }

        private TreeNode getRight(Deque<TreeNode> stack) {
            TreeNode root = stack.pop();
            TreeNode node = root.left;
            while (node != null) {
                stack.push(node);
                node = node.right;
            }
            return root;
        }
    }

}
