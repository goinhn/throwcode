package com.goinhn.leetcode._101_200;

/**
 * 108.将有序数组转换为二叉搜索树
 *
 * @author goinhn
 * @date 2021/11/20
 */
public class Sol108 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 将中间节点作为每个叶子树的根节点
     * <p>
     * time:O(n)
     * space:(logn)
     */
    private static class Solution1 {
        public static TreeNode sortedArrayToBST(int[] nums) {
            return treeHelper(nums, 0, nums.length);
        }

        private static TreeNode treeHelper(int[] nums, int left, int right) {
            if (left > right) {
                return null;
            }

            int mid = (left + right) >> 1;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = treeHelper(nums, left, mid - 1);
            root.right = treeHelper(nums, mid + 1, right);
            return root;
        }
    }
}
