package com.goinhn.algorithm.datastructure.tree.traversetree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <p>
 *
 * </p>
 *
 * @author goinhn
 * @date 2020-09-17T14:54:56
 */
public class PostOrder {

    /**
     * 后序遍历递归版本
     *
     * @param binaryTree
     * @param list
     * @return
     */
    public static List<BinaryTree> afterOrderPrint(BinaryTree binaryTree, List<BinaryTree> list) {
        if (binaryTree != null) {
            list = afterOrderPrint(binaryTree.left, list);
            list = afterOrderPrint(binaryTree.right, list);
            list.add(binaryTree);
        }

        return list;
    }

    /**
     * 后序遍历非递归版本
     *
     * @param binaryTree
     * @return
     */
    public static List<BinaryTree> afterOrderPrint(BinaryTree binaryTree) {
        List<BinaryTree> list = new ArrayList<>();
        Stack<BinaryTree> treeNodeStack = new Stack<>();
        BinaryTree node = binaryTree;
        BinaryTree lastVisit = binaryTree;

        while (node != null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }

            node = treeNodeStack.peek();

            if (node.right == null || node.right == lastVisit) {
                list.add(node);
                treeNodeStack.pop();
                lastVisit = node;
                node = null;
            } else {
                node = node.right;
            }
        }

        return list;
    }

}
