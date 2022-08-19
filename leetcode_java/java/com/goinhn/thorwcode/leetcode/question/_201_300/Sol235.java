package com.goinhn.thorwcode.leetcode.question._201_300;

import java.util.ArrayList;
import java.util.List;

/**
 * 235.二叉搜索树的最近公共祖先
 *
 * @author goinhn
 * @date 2021/12/12
 */
public class Sol235 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 两次遍历
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            List<TreeNode> pList = findThePathToNode(root, p);
            List<TreeNode> qList = findThePathToNode(root, q);
            TreeNode maxEqual = null;
            // 找到最后公共的部分，返回该节点
            for (int i = 0; i < pList.size() && i < qList.size(); i++) {
                if (pList.get(i) == qList.get(i)) {
                    maxEqual = pList.get(i);
                } else {
                    break;
                }
            }

            return maxEqual;
        }

        private List<TreeNode> findThePathToNode(TreeNode root, TreeNode target) {
            List<TreeNode> result = new ArrayList<>();
            while (root != null) {
                if (root.val > target.val) {
                    result.add(root);
                    root = root.left;
                } else if (root.val < target.val) {
                    result.add(root);
                    root = root.right;
                } else {
                    result.add(root);
                    break;
                }
            }

            return result;
        }

    }

    /**
     * 一次遍历，递归方法
     * time:O(n)
     * space:O(1)
     */
    private static class Solution2 {

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root.val > p.val && root.val > q.val) {
                return lowestCommonAncestor(root.left, p, q);
            } else if (root.val < p.val && root.val < q.val) {
                return lowestCommonAncestor(root.right, p, q);
            } else {
                return root;
            }
        }

    }

    /**
     * 按照二叉搜索树的特性来进行一次遍历
     * time:O(n)
     * space:O(1)
     */
    private static class Solution3 {

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            while (root != null) {
                if (root.val > p.val && root.val < q.val) {
                    root = root.left;
                } else if (root.val < p.val && root.val < q.val) {
                    root = root.right;
                } else {
                    break;
                }
            }

            return root;
        }

    }

}