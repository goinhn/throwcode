package com.goinhn.thorwcode.leetcode.question._201_300;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 二叉搜索树的最近公共祖先
 * <p>
 * 两次遍历的方式，找出到两个节点的路径，找出分叉口就是最近的公共节点
 * <p>
 * time:O(n)
 * space:O(n)
 * </p>
 *
 * @author goinhn
 * @date 2020-12-20T15:25:47
 */
public class Solution_235_1 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


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

}
