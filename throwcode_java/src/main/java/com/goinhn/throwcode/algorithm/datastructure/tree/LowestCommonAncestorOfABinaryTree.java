package com.goinhn.throwcode.algorithm.datastructure.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 二叉树的最近公共祖先
 * leetcode 236
 *
 * @author goinhn
 * @date 2020-12-21T22:21:48
 */
public class LowestCommonAncestorOfABinaryTree {

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
     * 当前寻找节点存在于二叉树中
     * 如果需要判断当前节点是否都在树内部则直接在返回的结果为其中一个节点的时候进行子树遍历判断即可
     * time:O(n)
     * space:O(n)
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        // 如果当前节点为空，或者节点和p或者q重合，那么就直接返回该节点即可
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);

        // 如果左边和右边都不为空的话，那么当前的根节点就是为最近的公共祖先节点
        return left == null ? right : right == null ? left : root;
    }


    private Map<TreeNode, TreeNode> map;

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        map = new HashMap<>();
        // 记录当前所有节点的父节点
        dfs(root);

        // 记录其中一个节点的路径
        Set<TreeNode> set = new HashSet<>();
        set.add(p);
        TreeNode nodeP = map.get(p);
        while (nodeP != null) {
            set.add(nodeP);
            nodeP = map.get(nodeP);
        }

        // 遍历另一个节点的路径，找到第一个重复的即可
        TreeNode nodeQ = q;
        while (nodeQ != null && !set.contains(nodeQ)) {
            nodeQ = map.get(nodeQ);
        }

        return nodeQ;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            map.put(node.left, node);
            dfs(node.left);
        }
        if (node.right != null) {
            map.put(node.right, node);
            dfs(node.right);
        }
    }

}
