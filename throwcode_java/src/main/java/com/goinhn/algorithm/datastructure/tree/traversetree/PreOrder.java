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
public class PreOrder {

    /**
     * 递归前序遍历
     *
     * @param binaryTree
     * @param list
     * @return
     */
    public static List<BinaryTree> preOrderPrint(BinaryTree binaryTree, List<BinaryTree> list) {
        if (binaryTree != null) {
            list.add(binaryTree);
            list = preOrderPrint(binaryTree.left, list);
            list = preOrderPrint(binaryTree.right, list);
        }

        return list;
    }

    /**
     * 非递归前序遍历
     *
     * @param binaryTree
     * @return
     */
    public static List<BinaryTree> preOrderPrint(BinaryTree binaryTree) {
        List<BinaryTree> list = new ArrayList<>();

        // 用来暂存节点的栈
        Stack<BinaryTree> treeNodeStack = new Stack<BinaryTree>();
        // 新建一个游标节点为根节点
        BinaryTree node = binaryTree;
        // 当遍历到最后一个节点的时候，无论它的左右子树都为空，并且栈也为空
        // 所以，只要不同时满足这两点，都需要进入循环
        while (node != null || !treeNodeStack.isEmpty()) {
            // 若当前考查节点非空，则输出该节点的值
            // 由考查顺序得知，需要一直往左走
            while (node != null) {
                list.add(node);
                // 为了之后能找到该节点的右子树，暂存该节点
                treeNodeStack.push(node);
                node = node.left;
            }
            // 一直到左子树为空，则开始考虑右子树
            // 如果栈已空，就不需要再考虑
            // 弹出栈顶元素，将游标等于该节点的右子树
            if (!treeNodeStack.isEmpty()) {
                node = treeNodeStack.pop();
                node = node.right;
            }
        }

        return list;
    }

}
