package com.goinhn.sworddirectoffer;

import java.util.ArrayList;

/**
 * <p>
 * 从上往下打印二叉树
 *
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * </p>
 *
 * @author goinhn
 * @date 2020-12-10T00:39:04
 */
public class JZ22 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     *利用队列的
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null) {
            return null;
        }

//        存储节点顺序的队列
        ArrayList<TreeNode> listNode = new ArrayList<>();
//        存储按层是输出的值的队列
        ArrayList<Integer> listVal = new ArrayList<>();
        listNode.add(root);

        while (listNode.size() != 0) {
            TreeNode temp = listNode.remove(0);
//            将左右节点按照顺序加入队列中
            if (temp.left != null) {
                listNode.add(temp.left);
            }
            if (temp.right != null) {
                listNode.add(temp.right);
            }
            listVal.add(temp.val);
        }

        return listVal;
    }

}
