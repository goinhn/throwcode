package com.goinhn.algorithm.search;

import java.util.*;
import java.util.List;

/**
 * <p>
 * 广度优先搜索算法
 * </p>
 *
 * @author goinhn
 * @date 2020-12-23T19:26:45
 */
public class BFS {

    /**
     * 二叉树
     */
    public static class BinaryTree {
        public int val;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int val) {
            this.val = val;
        }
    }

    /**
     * 使用queue实现二叉树BFS
     *
     * @param root
     */
    public List<BinaryTree> withQueueToBinaryTreeBFS(BinaryTree root) {
//        存储最后的结果
        List<BinaryTree> list = new LinkedList<>();
        if (root != null) {
//            存储中间过程中的节点
            Queue<BinaryTree> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                root = queue.poll();

//                处理遍历到的树的节点
                list.add(root);

                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }
            }
        }

        return list;
    }


    /**
     * N叉树
     */
    public class Tree {
        public int val;
        public List<Tree> children;

        public Tree(int val) {
            this.val = val;
        }
    }

    /**
     * 使用queue的方式来实现N叉树
     *
     * @param root
     * @return
     */
    public List<Tree> withQueueToTreeBFS(Tree root) {
        List<Tree> list = new LinkedList<>();
        if (root != null) {
            Queue<Tree> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                root = queue.poll();
                list.add(root);

                if (root.children != null) {
                    for (int i = 0; i < root.children.size(); i++) {
                        if (root.children.get(i) != null) {
                            queue.add(root.children.get(i));
                        }
                    }
                }
            }
        }

        return list;
    }


    /**
     * 图
     */
    public class Graph {
        public int val;
        public List<Graph> children;

        public Graph(int val) {
            this.val = val;
        }
    }


    /**
     * 使用队列的方式来实现图的BFS
     *
     * @param root
     * @return
     */
    public List<Graph> withQueueToGraph(Graph root) {
        List<Graph> list = new LinkedList<>();
        if (root != null) {
//            存储遍历过的节点
            Set<Graph> set = new HashSet<>();
            Queue<Graph> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                root = queue.poll();
                if (!set.contains(root)) {
                    list.add(root);
                    set.add(root);
                }

                if (root.children != null) {
                    for (int i = 0; i < root.children.size(); i++) {
                        if (root.children.get(i) != null) {
                            queue.add(root.children.get(i));
                        }
                    }
                }
            }
        }

        return list;
    }


}
