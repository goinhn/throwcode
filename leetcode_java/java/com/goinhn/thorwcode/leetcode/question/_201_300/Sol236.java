package com.goinhn.thorwcode.leetcode.question._201_300;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author goinhn
 * @date 2022/6/22
 */
public class Sol236 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 遍历递归
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // 如果当前节点为空，或者节点和p或者q重合，那么就直接返回该节点即可
            if (root == null || root == p || root == q) {
                return root;
            }

            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            // 如果左边和右边都不为空的话，那么当前的根节点就是为最近的公共祖先节点
            return left == null ? right : right == null ? left : root;
        }

    }

    /**
     * 利用哈希构建父节点映射关系来查找
     * time:O(n)
     * space:O(n)
     */
    private static class Solution2 {

        private Map<TreeNode, TreeNode> map;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            map = new HashMap<>();
            dfs(root);

            Set<TreeNode> set = new HashSet<>();
            set.add(p);
            TreeNode nodeP = map.get(p);
            while (nodeP != null) {
                set.add(nodeP);
                nodeP = map.get(nodeP);
            }

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

}
