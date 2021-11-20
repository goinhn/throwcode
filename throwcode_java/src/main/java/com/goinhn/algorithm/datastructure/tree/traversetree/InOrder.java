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
public class InOrder {

    /**
     * 中序遍历递归版本
     *
     * @param binaryTree
     * @param list
     * @return
     */
    public static List<BinaryTree> inOrderPrint(BinaryTree binaryTree, List<BinaryTree> list) {
        if (binaryTree != null) {
            list = inOrderPrint(binaryTree.left, list);
            list.add(binaryTree);
            list = inOrderPrint(binaryTree.right, list);
        }

        return list;
    }


    /**
     * 中序遍历非递归版本
     *
     * @param binaryTree
     * @return
     */
    public static List<BinaryTree> inOrderPrint(BinaryTree binaryTree) {
        List<BinaryTree> list = new ArrayList<>();

        Stack<BinaryTree> treeNodeStack = new Stack<BinaryTree>();
        BinaryTree node = binaryTree;

        while (node != null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }

            if (!treeNodeStack.isEmpty()) {
                node = treeNodeStack.pop();
                list.add(node);
                node = node.right;
            }
        }

        return list;
    }


}
