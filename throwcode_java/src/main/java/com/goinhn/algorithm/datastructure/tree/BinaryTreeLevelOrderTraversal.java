package com.goinhn.algorithm.datastructure.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * <p>
 * leetcode 102
 * 二叉树层序遍历
 * <p>
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层序遍历结果：
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 *
 * </p>
 *
 * @author goinhn
 * @date 2020-12-22T16:46:52
 */
public class BinaryTreeLevelOrderTraversal {

    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 使用BFS的方式进行层次遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBFS(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new LinkedList<>();
//            保持当前层的size大小
            int currentLevelSize = queue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                root = queue.poll();
                level.add(root.val);
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
            }
            result.add(level);
        }

        return result;
    }


    private List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> levelOrderDFS(TreeNode root) {
        if (root == null) {
            return result;
        }

        dfsHelper(root, 0);

        return result;
    }


    /**
     * DFS递归的方式来进行层次遍历，在每次递归的时候带上层数
     *
     * @param root
     * @param level
     */
    public void dfsHelper(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (result.size() < level + 1) {
            result.add(new LinkedList<>());
        }

        result.get(level).add(root.val);

        dfsHelper(root.left, level + 1);
        dfsHelper(root.right, level + 1);
    }


    /**
     * DFS非递归的方式，使用一个辅助的栈来保存各个节点的层次信息
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderDFSStack(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
//        使用一个辅助栈来保存各个节点的层数，也可以放置在树本身的结构中
        Stack<Integer> levelStack = new Stack<>();
        stack.push(root);
        levelStack.add(0);
        while (!stack.isEmpty()) {
            root = stack.pop();
            int level = levelStack.pop();
            if (list.size() < level + 1) {
                list.add(new LinkedList<>());
            }
            list.get(level).add(root.val);
            if (root.right != null) {
                stack.push(root.right);
                levelStack.push(level + 1);
            }
            if (root.left != null) {
                stack.push(root.left);
                levelStack.push(level + 1);
            }
        }

        return list;
    }

}
