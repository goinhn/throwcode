package com.goinhn.algorithm.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * leetcode 235
 * <p>
 * 二叉搜索树的最近公共祖先
 * </p>
 *
 * @author goinhn
 * @date 2020-12-20T15:25:47
 */
public class LowestCommonAncestorOfABinarySearchTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    /**
     * 二次遍历
     * <p>
     * time:O(n)
     * space:O(n)
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pList = findThePathToNode(root, p);
        List<TreeNode> qList = findThePathToNode(root, q);
        TreeNode maxEqual = null;
//        找到最后公共的部分，返回该节点
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
     *
     * @param root
     * @param target
     * @return
     */
    public List<TreeNode> findThePathToNode(TreeNode root, TreeNode target) {
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
     * time:O(n)
     * space:O(n)
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestorOne(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode rootTemp = root;
        while (root != null) {
            if (rootTemp.val > p.val && rootTemp.val > q.val) {
                rootTemp = rootTemp.left;
            } else if (rootTemp.val < p.val && rootTemp.val < q.val) {
                rootTemp = rootTemp.right;
//               出现分叉的地方，即为最近的公共的节点
            } else {
                break;
            }
        }

        return rootTemp;
    }
}
