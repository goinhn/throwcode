package com.goinhn.throwcode.algorithm.datastructure.tree.traversetree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的后序遍历
 *
 * @author goinhn
 * @date 2020-09-17T14:54:56
 */
public class AfterOrder {

    private static List<BinaryTreeNode> resList;

    /**
     * 后序遍历递归版本
     */
    public static List<BinaryTreeNode> afterOrderRecursion(BinaryTreeNode node) {
        resList = new ArrayList<>();

        dfs(node);

        return resList;
    }

    private static void dfs(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

        dfs(node.left);
        dfs(node.right);
        resList.add(node);
    }

    /**
     * 后序遍历非递归版本
     */
    public static List<BinaryTreeNode> afterOrder(BinaryTreeNode node) {
        List<BinaryTreeNode> resList = new ArrayList<>();
        Stack<BinaryTreeNode> nodeStack = new Stack<>();
        BinaryTreeNode lastVisit = node;
        while (node != null || !nodeStack.isEmpty()) {
            while (node != null) {
                nodeStack.push(node);
                node = node.left;
            }

            node = nodeStack.peek();

            if (node.right == null || node.right == lastVisit) {
                resList.add(node);
                nodeStack.pop();
                lastVisit = node;
                node = null;
            } else {
                node = node.right;
            }
        }

        return resList;
    }

    /**
     * 后序遍历非递归版本
     * 使用辅助栈进行，先使用中右左的方式进行存储，然后再使用栈进行倒置
     */
    public static List<BinaryTreeNode> afterOrderV2(BinaryTreeNode node) {
        if (node == null) {
            return Collections.emptyList();
        }

        Stack<BinaryTreeNode> nodeStack = new Stack<>();
        List<BinaryTreeNode> resList = new ArrayList<>();
        nodeStack.push(node);
        while (!nodeStack.isEmpty()) {
            node = nodeStack.pop();
            resList.add(node);
            if (node.left != null) {
                nodeStack.push(node.left);
            }

            if (node.right != null) {
                nodeStack.push(node.right);
            }
        }

        Collections.reverse(resList);

        return resList;
    }


    /**
     * 后序遍历非递归版本
     */
    public static List<BinaryTreeNode> afterOrderV3(BinaryTreeNode node) {
        if (node == null) {
            return Collections.emptyList();
        }

        List<BinaryTreeNode> resList = new ArrayList<>();
        Stack<BinaryTreeNode> nodeStack = new Stack<>();
        nodeStack.push(node);
        BinaryTreeNode temp = null;
        while (!nodeStack.isEmpty()) {
            temp = nodeStack.peek();
            if (temp.left != null && node != temp.left && node != temp.right) {
                nodeStack.push(temp.left);
            } else if (temp.right != null && node != temp.right) {
                nodeStack.push(temp.right);
            } else {
                resList.add(node);
                node = temp;
            }
        }

        return resList;
    }

}
