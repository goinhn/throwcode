//package com.goinhn.throwcode.codinginterviews.temp;
//
//
///**
// * <p>
// * 重建二叉树
// * <p>
// * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
// * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
// * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
// * </p>
// *
// * @author goinhn
// * @date 2020-12-07T11:09:33
// */
//public class JZ04 {
//    public static class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode(int val) {
//            this.val = val;
//        }
//    }
//
//    public static void main(String[] args) {
////        前中后序数组
//        int[] pre = {1, 2, 3, 4, 5, 6, 7};
//        int[] in = {3, 2, 4, 1, 6, 5, 7};
//        int[] aft = {3, 4, 2, 6, 7, 5, 1};
//
//        TreeNode preIn = new JZ04().reConstructBinaryTree(pre, in);
//        TreeNode inAft = new JZ04().reConstructBinaryTreeAfter(in, aft);
//        printTreeNodePre(preIn);
//        System.out.println();
//        printTreeNodeIn(preIn);
//        System.out.println();
//        printTreeNodeAft(preIn);
//        System.out.println();
//        printTree(preIn);
//
//
//        printTreeNodePre(inAft);
//        System.out.println();
//        printTreeNodeIn(inAft);
//        System.out.println();
//        printTreeNodeAft(inAft);
//        System.out.println();
//        printTree(inAft);
//    }
//
//    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
//        if (pre == null || in == null || pre.length == 0 || in.length == 0) {
//            return null;
//        }
//
//        return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
//    }
//
//
//    public TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
//        if (startPre > endPre || startIn > endIn) {
//            return null;
//        }
//
////        确定头节点
//        TreeNode root = new TreeNode(pre[startPre]);
//        for (int i = 0; i < in.length; i++) {
//            if (pre[startPre] == in[i]) {
//                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
//                root.right = reConstructBinaryTree(pre, startPre + i - startIn + 1, endPre, in, i + 1, endIn);
//                break;
//            }
//        }
//
//        return root;
//    }
//
//
//    public TreeNode reConstructBinaryTreeAfter(int[] in, int[] aft) {
//        if (in == null || aft == null || in.length == 0 || aft.length == 0) {
//            return null;
//        }
//
//        return reConstructBinaryTreeAfter(in, 0, in.length - 1, aft, 0, aft.length - 1);
//    }
//
//    /**
//     * 中序和后续构造二叉树
//     *
//     * @param in
//     * @param startIn
//     * @param endIn
//     * @param aft
//     * @param startAft
//     * @param endAft
//     * @return
//     */
//    public TreeNode reConstructBinaryTreeAfter(int[] in, int startIn, int endIn, int[] aft, int startAft, int endAft) {
//        if (startIn > endIn || startAft > endAft) {
//            return null;
//        }
//
//        TreeNode root = new TreeNode(aft[endAft]);
//        for (int i = 0; i < in.length; i++) {
//            if (aft[endAft] == in[i]) {
//                root.left = reConstructBinaryTreeAfter(in, startIn, i - 1, aft, startAft, endAft - endIn + i - 1);
//                root.right = reConstructBinaryTreeAfter(in, i + 1, endIn, aft, endAft - endIn + i, endAft - 1);
//                break;
//            }
//        }
//
//        return root;
//    }
//
//}
