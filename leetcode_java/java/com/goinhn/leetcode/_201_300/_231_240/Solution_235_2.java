package com.goinhn.leetcode._201_300._231_240;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 二叉搜索树的最近公共祖先
 * <p>
 * 一次遍历的方式，找出到两个节点的路径，找出分叉口就是最近的公共节点
 * 同时寻找两个节点的路径，分叉的时候就是最近的祖先
 * <p>
 * time:O(n)
 * space:O(1)
 * </p>
 *
 * @author goinhn
 * @date 2020-12-20T15:25:47
 */
public class Solution_235_2 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    /**
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
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
