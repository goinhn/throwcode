package com.goinhn.thorwcode.leetcode.question._501_600;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 508.出现次数最多的子元素之和
 *
 * @author goinhn
 * @date 2022/6/19
 */
public class Sol508 {

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
     * dfs + 哈希映射
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {

        /**
         * 存储每个子树和的出现次数
         */
        private static Map<Integer, Integer> countMap;

        /**
         * 存储最子树和的最大次数
         */
        private static int maxNum;

        public int[] findFrequentTreeSum(TreeNode root) {
            countMap = new HashMap<>();
            maxNum = Integer.MIN_VALUE;

            dfs(root);

            List<Integer> resList = new ArrayList<>();
            for (Integer num : countMap.keySet()) {
                if (countMap.get(num) == maxNum) {
                    resList.add(num);
                }
            }

            return resList.stream().mapToInt(i -> i).toArray();
        }

        private int dfs(TreeNode node) {
            if (node == null) {
                return 0;
            }

            int left = dfs(node.left);
            int right = dfs(node.right);

            int nodeNum = left + right + node.val;
            int count = countMap.getOrDefault(nodeNum, 0) + 1;
            if (count > maxNum) {
                maxNum = count;
            }
            countMap.put(nodeNum, count);

            return nodeNum;
        }

    }

}
