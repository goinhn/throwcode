package com.goinhn.throwcode.codinginterviews.search_backtracking;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 26.树的子结构
 *
 * @author goinhn
 * @date 2020-12-09T16:30:03
 */
public class Jz26 {

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * DFS
     * time:O(mn)
     * space:O(m)
     */
    private static class Solution1 {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            return A != null && B != null
                    && (isSubTree(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
        }

        public boolean isSubTree(TreeNode A, TreeNode B) {
            if (B == null) {
                return true;
            }

            if (A == null || A.val != B.val) {
                return false;
            }

            return isSubTree(A.left, B.left) && isSubTree(A.right, B.right);
        }
    }

    /**
     * BFS
     * time:O(mn)
     * space:O(m)
     */
    private static class Solution2 {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (A == null || B == null) {
                return false;
            }

            Queue<TreeNode> queueNode = new LinkedList<>();
            queueNode.offer(A);
            while (!queueNode.isEmpty()) {
                TreeNode tempNode = queueNode.poll();
                if (tempNode.val == B.val) {
                    if (isSubTree(tempNode, B)) {
                        return true;
                    }
                }
                if (tempNode.left != null) {
                    queueNode.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queueNode.add(tempNode.right);
                }
            }

            return false;
        }

        public boolean isSubTree(TreeNode A, TreeNode B) {
            Queue<TreeNode> queueA = new LinkedList<>();
            Queue<TreeNode> queueB = new LinkedList<>();
            queueA.add(A);
            queueB.add(B);
            while (!queueB.isEmpty()) {
                TreeNode tempA = queueA.poll();
                TreeNode tempB = queueB.poll();
                if (tempA == null || tempA.val != tempB.val) {
                    return false;
                }
                if (tempB.left != null) {
                    queueA.add(tempA.left);
                    queueB.add(tempB.left);
                }
                if (tempB.right != null) {
                    queueA.add(tempA.right);
                    queueB.add(tempB.right);
                }
            }
            return true;
        }
    }
}
