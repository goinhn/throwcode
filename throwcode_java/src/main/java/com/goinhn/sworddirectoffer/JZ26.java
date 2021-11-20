package com.goinhn.sworddirectoffer;

/**
 * <p>
 * 二叉搜索树和双向链表
 * <p>
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * </p>
 *
 * @author goinhn
 * @date 2020-12-14T20:27:19
 */
public class JZ26 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 保存前一个节点
     */
    private TreeNode preNode = null;
    /**
     * 保存最后返回的头节点
     */
    private TreeNode resultNode = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        convertHelp(pRootOfTree);
        return resultNode;
    }

    /**
     * 使用中序遍历
     *
     * @param root
     */
    public void convertHelp(TreeNode root) {
        if (root == null) {
            return;
        }

        Convert(root.left);
        if (preNode == null) {
            preNode = root;
            resultNode = root;
        } else {
            preNode.right = root;
            root.left = preNode;
            preNode = root;
        }
        Convert(root.right);
    }


}
