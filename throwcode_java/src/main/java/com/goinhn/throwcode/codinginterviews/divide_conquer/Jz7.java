package com.goinhn.throwcode.codinginterviews.divide_conquer;

import java.util.HashMap;

/**
 * @author goinhn
 * @date 2022/6/15
 */
public class Jz7 {

    private static class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    /**
     * 分治法
     * <p>
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {

        private int[] preorder;

        private HashMap<Integer, Integer> inOrderIndexMap;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preorder = preorder;
            inOrderIndexMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                inOrderIndexMap.put(inorder[i], i);
            }
            return recur(0, 0, inorder.length - 1);
        }

        private TreeNode recur(int root, int left, int right) {
            if (left > right) {
                return null;
            }

            TreeNode node = new TreeNode(preorder[root]);
            int splitIndex = inOrderIndexMap.get(preorder[root]);

            // 头节点按照前序遍历数组的位置
            // 左右边界按照中序遍历数组的位置
            node.left = recur(root + 1, left, splitIndex - 1);
            node.right = recur(root + (splitIndex + 1) - left, splitIndex + 1, right);

            return node;
        }

    }

}
