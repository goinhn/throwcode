package com.goinhn.throwcode.algorithm.datastructure.tree.traversetree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 *
 * @author goinhn
 * @date 2020-09-17T14:54:56
 */
public class InOrder {

    private static List<BinaryTreeNode> resList;

    /**
     * 中序遍历递归版本
     */
    public static List<BinaryTreeNode> inOrderRecursion(BinaryTreeNode node) {
        resList = new ArrayList<>();

        dfs(node);

        return resList;
    }

    private static void dfs(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

        dfs(node.left);
        resList.add(node);
        dfs(node.right);
    }


    /**
     * 中序遍历非递归版本
     */
    public static List<BinaryTreeNode> inOrder(BinaryTreeNode node) {
        List<BinaryTreeNode> resList = new ArrayList<>();
        Stack<BinaryTreeNode> nodeStack = new Stack<>();
        while (node != null || !nodeStack.isEmpty()) {
            while (node != null) {
                nodeStack.push(node);
                node = node.left;
            }

            node = nodeStack.pop();
            resList.add(node);
            node = node.right;
        }

        return resList;
    }


    /**
     * 中序遍历非递归版本
     */
    public static List<BinaryTreeNode> inOrderV2(BinaryTreeNode node) {
        if (node == null) {
            return Collections.emptyList();
        }

        List<BinaryTreeNode> resList = new ArrayList<>();
        Stack<BinaryTreeNode> nodeStack = new Stack<>();
        while (!nodeStack.isEmpty() || node != null) {
            if (node != null) {
                nodeStack.push(node);
                node = node.left;
            } else {
                node = nodeStack.pop();
                resList.add(node);
                node = node.right;
            }
        }

        return resList;
    }

}
