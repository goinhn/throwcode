package com.goinhn.throwcode.algorithm.datastructure.tree.traversetree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前序遍历
 *
 * @author goinhn
 * @date 2020-09-17T14:54:56
 */
public class PreOrder {

    private static List<BinaryTreeNode> resList;

    /**
     * 前序遍历递归版本
     */
    public static List<BinaryTreeNode> preOrderRecursion(BinaryTreeNode node) {
        resList = new ArrayList<>();

        dfs(node);

        return resList;
    }

    private static void dfs(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

        resList.add(node);
        dfs(node.left);
        dfs(node.right);
    }

    /**
     * 前序遍历非递归版本
     */
    public static List<BinaryTreeNode> preOrder(BinaryTreeNode node) {
        List<BinaryTreeNode> resList = new ArrayList<>();
        Stack<BinaryTreeNode> nodeStack = new Stack<>();

        // 当遍历到最后一个节点的时候，无论它的左右子树都为空，并且栈也为空
        // 所以，只要不同时满足这两点，都需要进入循环
        while (node != null || !nodeStack.isEmpty()) {
            // 若当前考查节点非空，则输出该节点的值
            // 由考查顺序得知，需要一直往左走
            while (node != null) {
                resList.add(node);
                // 为了之后能找到该节点的右子树，暂存该节点
                nodeStack.push(node);
                node = node.left;
            }

            // 一直到左子树为空，则开始考虑右子树
            // 如果栈已空，就不需要再考虑
            // 弹出栈顶元素，将游标等于该节点的右子树
            if (!nodeStack.isEmpty()) {
                node = nodeStack.pop();
                node = node.right;
            }
        }

        return resList;
    }

    /**
     * 前序遍历非递归版本
     */
    public static List<BinaryTreeNode> preOrderV2(BinaryTreeNode node) {
        if (node == null) {
            return Collections.emptyList();
        }

        List<BinaryTreeNode> resList = new ArrayList<>();
        Stack<BinaryTreeNode> nodeStack = new Stack<>();
        nodeStack.add(node);
        while (!nodeStack.isEmpty()) {
            node = nodeStack.pop();
            resList.add(node);
            if (node.right != null) {
                nodeStack.push(node.right);
            }
            if (node.left != null) {
                nodeStack.push(node.left);
            }
        }

        return resList;
    }

}
