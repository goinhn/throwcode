package com.goinhn.leetcode._101_200;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * <p>
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
 * <p>
 * <p>
 * 使用DFS将结果输出到准备好的数组上
 * <p>
 * time:O(n)
 * space:O(n)
 * </p>
 *
 * @author goinhn
 * @date 2020-12-22T16:46:52
 */
public class Solution_102_2 {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
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
     * 递归辅助函函数
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

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(5);
        treeNode.right.right = new TreeNode(6);

        List<List<Integer>> list = new Solution_102_2().levelOrderDFSStack(treeNode);

        for (List<Integer> integers : list) {
            System.out.println(integers);
        }
    }
}
