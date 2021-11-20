package com.goinhn.algorithm.datastructure.tree;

/**
 * <p>
 * 寻找中序遍历中的前驱和后继节点
 * </p>
 *
 * @author goinhn
 * @date 2020-08-28T16:27:15
 */
public class PrecursorSuccessorNode {

    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 获得前驱节点
     *
     * @param node
     * @return
     */
    public static Node getPrecursorNode(Node node) {
        if (node == null) {
            return node;
        }
        if (node.left != null) {
            node = node.left;
            while (node.right != null) {
                node = node.right;
            }
            return node;
        } else {
            Node parent = node.parent;
            while (parent != null && parent.right != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    /**
     * 获得后继节点
     *
     * @param node
     * @return
     */
    public static Node getSuccessorNode(Node node) {
        if (node == null) {
            return node;
        }
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            Node parent = node.parent;
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(6);
        head.parent = null;
        head.left = new Node(3);
        head.left.parent = head;
        head.left.left = new Node(1);
        head.left.left.parent = head.left;
        head.left.left.right = new Node(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new Node(4);
        head.left.right.parent = head.left;
        head.left.right.right = new Node(5);
        head.left.right.right.parent = head.left.right;
        head.right = new Node(9);
        head.right.parent = head;
        head.right.left = new Node(8);
        head.right.left.parent = head.right;
        head.right.left.left = new Node(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new Node(10);
        head.right.right.parent = head.right;

        Node successorTest = head.left.left;
        System.out.println(successorTest.value + " next: " + getSuccessorNode(successorTest).value);
        successorTest = head.left.left.right;
        System.out.println(successorTest.value + " next: " + getSuccessorNode(successorTest).value);
        successorTest = head.left;
        System.out.println(successorTest.value + " next: " + getSuccessorNode(successorTest).value);
        successorTest = head.left.right;
        System.out.println(successorTest.value + " next: " + getSuccessorNode(successorTest).value);
        successorTest = head.left.right.right;
        System.out.println(successorTest.value + " next: " + getSuccessorNode(successorTest).value);
        successorTest = head;
        System.out.println(successorTest.value + " next: " + getSuccessorNode(successorTest).value);
        successorTest = head.right.left.left;
        System.out.println(successorTest.value + " next: " + getSuccessorNode(successorTest).value);
        successorTest = head.right.left;
        System.out.println(successorTest.value + " next: " + getSuccessorNode(successorTest).value);
        successorTest = head.right;
        System.out.println(successorTest.value + " next: " + getSuccessorNode(successorTest).value);
        // 10's next is null
        successorTest = head.right.right;
        System.out.println(successorTest.value + " next: " + getSuccessorNode(successorTest));

        System.out.println();

        // 0's next is null
        Node precursorTest = head.left.left;
        System.out.println(precursorTest.value + " pre: " + getPrecursorNode(precursorTest));
        precursorTest = head.left.left.right;
        System.out.println(precursorTest.value + " pre: " + getPrecursorNode(precursorTest).value);
        precursorTest = head.left;
        System.out.println(precursorTest.value + " pre: " + getPrecursorNode(precursorTest).value);
        precursorTest = head.left.right;
        System.out.println(precursorTest.value + " pre: " + getPrecursorNode(precursorTest).value);
        precursorTest = head.left.right.right;
        System.out.println(precursorTest.value + " pre: " + getPrecursorNode(precursorTest).value);
        precursorTest = head;
        System.out.println(precursorTest.value + " pre: " + getPrecursorNode(precursorTest).value);
        precursorTest = head.right.left.left;
        System.out.println(precursorTest.value + " pre: " + getPrecursorNode(precursorTest).value);
        precursorTest = head.right.left;
        System.out.println(precursorTest.value + " pre: " + getPrecursorNode(precursorTest).value);
        precursorTest = head.right;
        System.out.println(precursorTest.value + " pre: " + getPrecursorNode(precursorTest).value);
        precursorTest = head.right.right; // 10's pre is null
        System.out.println(precursorTest.value + " pre: " + getPrecursorNode(precursorTest).value);
    }

}
