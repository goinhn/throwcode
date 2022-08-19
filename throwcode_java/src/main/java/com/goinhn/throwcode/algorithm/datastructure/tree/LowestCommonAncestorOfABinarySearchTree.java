package com.goinhn.throwcode.algorithm.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树的最近公共祖先
 * leetcode 235
 *
 * @author goinhn
 * @date 2020-12-20T15:25:47
 */
public class LowestCommonAncestorOfABinarySearchTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    /**
     * 记录节点的路径来进行判断
     * time:O(n)
     * space:O(n)
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
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

    /**
     * 根据搜索二叉树的特性找到目标节点的位置，并且记录走过的路径
     */
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


    /**
     * 直接按照搜索二叉树的特性去进行遍历判断
     * time:O(n)
     * space:O(n)
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;

                // 出现分叉的地方，即为最近的公共的节点
            } else {
                break;
            }
        }

        return root;
    }
}
