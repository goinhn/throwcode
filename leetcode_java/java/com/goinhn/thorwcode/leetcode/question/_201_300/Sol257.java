package com.goinhn.thorwcode.leetcode.question._201_300;

import java.util.ArrayList;
import java.util.List;

/**
 * 257.二叉树的所有路径
 *
 * @author goinhn
 * @date 2021/12/14
 */
public class Sol257 {

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
     * 深度优先搜索
     * time:O()
     * space:O()
     */
    private static class Solution1 {
        public List<String> binaryTreePaths(TreeNode root) {
            if (null == root) {
                return new ArrayList<>();
            }
            List<String> pathList = new ArrayList<>();
            String rootPath = root.val + "";
            getPath(pathList, rootPath, root);
            return pathList;
        }

        public void getPath(List<String> pathList, String rootPath, TreeNode root) {
            if (root.left == null && root.right == null) {
                pathList.add(rootPath);
            }
            if (root.left != null) {
                String leftPath = rootPath;
                leftPath += "->" + root.left.val;
                getPath(pathList, leftPath, root.left);
            }
            if (root.right != null) {
                String rightPath = rootPath;
                rightPath += "->" + root.right.val;
                getPath(pathList, rightPath, root.right);
            }
        }
    }
}
