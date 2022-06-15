package com.goinhn.throwcode.algorithm.datastructure.tree.traversetree;

/**
 * 二叉树结构
 *
 * @author goinhn
 * @date 2020-09-17T14:55:16
 */
public class BinaryTreeNode {

    public int val;

    public BinaryTreeNode left;

    public BinaryTreeNode right;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(int val) {
        this.val = val;
    }

    public BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
