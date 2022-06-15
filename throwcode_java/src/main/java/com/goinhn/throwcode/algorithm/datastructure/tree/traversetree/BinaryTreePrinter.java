package com.goinhn.throwcode.algorithm.datastructure.tree.traversetree;

/**
 * 二叉树打印工具类
 *
 * @author goinhn
 * @date 2022/6/15
 */
public class BinaryTreePrinter {

    /**
     * 打印出树的形状
     */
    public static void print(BinaryTreeNode head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    private static void printInOrder(BinaryTreeNode head, int height, String to, int len) {
        if (head == null) {
            return;
        }

        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.val + to;
        int lenL = (len - val.length()) / 2;
        int lenR = len - val.length() - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    private static String getSpace(int num) {
        String space = " ";
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < num; i++) {
            stringBuilder.append(space);
        }
        return stringBuilder.toString();
    }

}
