package com.goinhn.throwcode.algorithm.search;

import java.util.*;

/**
 * <p>
 * 深度优先遍历
 * </p>
 *
 * @author goinhn
 * @date 2020-12-23T19:47:09
 */
public class DFS {

    /**
     * 二叉树
     */
    private static class BinaryTree {
        public int val;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int val) {
            this.val = val;
        }
    }

    /**
     * 使用递归的方式来进行二叉树DFS
     */
    private void withRecursionToBinaryTreeDFS(BinaryTree root) {
        if (root == null) {
            return;
        }

        System.out.println(root.val);

        if (root.left != null) {
            withRecursionToBinaryTreeDFS(root.left);
        }

        if (root.right != null) {
            withRecursionToBinaryTreeDFS(root.right);
        }
    }

    /**
     * 使用栈的方式实现二叉树的DFS
     */
    private List<BinaryTree> withStackToBinaryTreeDFS(BinaryTree root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Deque<BinaryTree> stack = new LinkedList<>();
        List<BinaryTree> list = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root);
            if (root.right != null) {
                stack.push(root.right);
            }

            if (root.left != null) {
                stack.push(root.left);
            }
        }

        return list;
    }

    /**
     * N叉树
     */
    private static class Tree {
        public int val;
        public List<Tree> children;

        public Tree(int val) {
            this.val = val;
        }
    }

    /**
     * 使用递归的方式来实现N叉树的DFS
     */
    private void withRecursionToTreeDFS(Tree root) {
        if (root == null) {
            return;
        }

        System.out.println(root.val);

        if (root.children != null) {
            for (int i = 0; i < root.children.size(); i++) {
                if (root.children.get(i) != null) {
                    withRecursionToTreeDFS(root.children.get(i));
                }
            }
        }
    }

    /**
     * 使用栈的方式来实现N叉树的DFS
     */
    private List<Tree> withStackToTreeDFS(Tree root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Deque<Tree> stack = new LinkedList<>();
        stack.push(root);
        List<Tree> list = new LinkedList<>();
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root);

            if (root.children != null) {
                int size = root.children.size();
                for (int i = 0; i < size; i++) {
                    stack.push(root.children.get(size - i - 1));
                }
            }
        }

        return list;
    }


    /**
     * 图
     */
    private static class Graph {
        public int val;
        public List<Graph> children;

        public Graph(int val) {
            this.val = val;
        }
    }

    /**
     * 存储遍历过的图的节点
     */
    private Set<Graph> set = new HashSet<>();

    /**
     * 使用递归的方式来实现图的DFS
     */
    private void withRecursionToGraphDFS(Graph root) {
        if (root == null) {
            return;
        }

        if (!set.contains(root)) {
            System.out.println(root.val);
            set.add(root);
        }

        if (root.children != null) {
            for (int i = 0; i < root.children.size(); i++) {
                if (root.children.get(i) != null) {
                    withRecursionToGraphDFS(root.children.get(i));
                }
            }
        }
    }

    /**
     * 使用栈的方式来实现图的DFS
     */
    private void withStackToGraphDFS(Graph root) {
        if (root == null) {
            return;
        }

        Deque<Graph> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            if (!set.contains(root)) {
                System.out.println(root.val);
                set.add(root);
            }

            if (root.children != null) {
                int size = root.children.size();
                for (int i = 0; i < size; i++) {
                    if(root.children.get(size - i - 1) != null) {
                        stack.push(root.children.get(size - i - 1));
                    }
                }
            }
        }
    }
}
