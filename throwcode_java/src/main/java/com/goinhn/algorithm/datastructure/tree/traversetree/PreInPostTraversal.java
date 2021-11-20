package com.goinhn.algorithm.datastructure.tree.traversetree;

import java.util.Stack;

/**
 * <p>
 * 二叉树的先中后序遍历
 * <p>
 * 递归和非递归的遍历
 * </p>
 *
 * @author goinhn
 * @date 2020-08-28T14:42:16
 */
public class PreInPostTraversal {

    public static class Tree {
        public int val;
        public Tree left;
        public Tree right;

        public Tree(int val) {
            this.val = val;
        }
    }

    // 递归遍历

    /**
     * 先序遍历
     *
     * @param root
     */
    public static void preOrderRecur(Tree root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrderRecur(root.left);
        preOrderRecur(root.right);
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    public static void inOrderRecur(Tree root) {
        if (root == null) {
            return;
        }
        inOrderRecur(root.left);
        System.out.print(root.val + " ");
        inOrderRecur(root.right);
    }

    /**
     * 后序遍历
     *
     * @param root
     */
    public static void posOrderRecur(Tree root) {
        if (root == null) {
            return;
        }
        posOrderRecur(root.left);
        posOrderRecur(root.right);
        System.out.print(root.val + " ");
    }


    // 非递归

    /**
     * 先序遍历
     *
     * @param root
     */
    public static void preOrderUnRecur(Tree root) {
        System.out.print("pre-order: ");
        if (root != null) {
            Stack<Tree> stack = new Stack<>();
            stack.add(root);
            while (!stack.isEmpty()) {
                root = stack.pop();
                System.out.print(root.val + " ");
                if (root.right != null) {
                    stack.push(root.right);
                }
                if (root.left != null) {
                    stack.push(root.left);
                }
            }
        }
        System.out.println();
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    public static void inOrderUnRecur(Tree root) {
        System.out.print("in-order: ");
        if (root != null) {
            Stack<Tree> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    System.out.print(root.val + " ");
                    root = root.right;
                }
            }
        }
        System.out.println();
    }

    /**
     * 后序遍历，使用辅助栈进行，先使用中右左的方式进行存储，然后再使用栈进行倒置
     *
     * @param root
     */
    public static void postOrderUnRecur1(Tree root) {
        System.out.print("pos-order: ");
        if (root != null) {
            Stack<Tree> recur = new Stack<>();
            Stack<Tree> result = new Stack<>();
            recur.push(root);
            while (!recur.isEmpty()) {
                root = recur.pop();
                result.push(root);
                if (root.left != null) {
                    recur.push(root.left);
                }
                if (root.right != null) {
                    recur.push(root.right);
                }
            }

            while (!result.isEmpty()) {
                System.out.print(result.pop().val + " ");
            }
        }
        System.out.println();
    }

    public static void postOrderUnRecur2(Tree root) {
        System.out.print("pos-order: ");
        if (root != null) {
            Stack<Tree> stack = new Stack<>();
            stack.push(root);
            Tree temp = null;
            while (!stack.isEmpty()) {
                temp = stack.peek();
                if (temp.left != null && root != temp.left && root != temp.right) {
                    stack.push(temp.left);
                } else if (temp.right != null && root != temp.right) {
                    stack.push(temp.right);
                } else {
                    System.out.print(stack.pop().val + " ");
                    root = temp;
                }
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Tree root = new Tree(5);
        root.left = new Tree(3);
        root.right = new Tree(8);
        root.left.left = new Tree(2);
        root.left.right = new Tree(4);
        root.left.left.left = new Tree(1);
        root.right.left = new Tree(7);
        root.right.left.left = new Tree(6);
        root.right.right = new Tree(10);
        root.right.right.left = new Tree(9);
        root.right.right.right = new Tree(11);

        // recursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        preOrderRecur(root);
        System.out.println();
        System.out.print("in-order: ");
        inOrderRecur(root);
        System.out.println();
        System.out.print("pos-order: ");
        posOrderRecur(root);
        System.out.println();

        // unrecursive
        System.out.println("============unrecursive=============");
        preOrderUnRecur(root);
        inOrderUnRecur(root);
        postOrderUnRecur1(root);
        postOrderUnRecur2(root);

    }

}
