package com.goinhn.algorithm.datastructure.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * <p>
 * leetcode 98
 * <p>
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * 示例1:
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * <p>
 * 示例2:
 * 输入:
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
 * </p>
 *
 * @author goinhn
 * @date 2020-09-17T15:46:03
 */
public class ValidateBinarySearchTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 使用中序遍历
     * <p>
     * time:O(n)
     * space:O(n)
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        list = InOrder(root);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }

        return true;
    }

    /**
     * 中序非递归进行遍历
     *
     * @param root
     * @return
     */
    public List<Integer> InOrder(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            if (!stack.isEmpty()) {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }

        return list;
    }


    /**
     * 使用递归函数，子树也为二叉搜索树
     * 判断条件：
     * 左子树最大的值小于节点，右子树最小的值大于中间的节点
     *
     * @param node
     * @param lower 当前节点为上一个节点的右子树的根节点，上一个节点的值
     * @param upper 当前节点为上一个节点的左子树的根节点，上一个节点的值
     * @return
     */
    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }

        int val = node.val;
        if (lower != null && val <= lower) {
            return false;
        }

        if (upper != null && val >= upper) {
            return false;
        }

        if (!helper(node.right, val, upper)) {
            return false;
        }

        if (!helper(node.left, lower, val)) {
            return false;
        }

        return true;
    }

}
