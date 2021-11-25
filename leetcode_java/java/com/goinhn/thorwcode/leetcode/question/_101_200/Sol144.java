/*
 * Copyright (C) 2021 Baidu, Inc. All Rights Reserved.
 */
package com.goinhn.thorwcode.leetcode.question._101_200;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fangwenzhan
 * @date 2021/11/25
 */
public class Sol144 {

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
     * 递归遍历
     * <p>
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            traverseHelper(root, list);
            return list;
        }

        public void traverseHelper(TreeNode root, List<Integer> list) {
            if (root != null) {
                list.add(root.val);
                traverseHelper(root.left, list);
                traverseHelper(root.right, list);
            }
        }
    }
}
