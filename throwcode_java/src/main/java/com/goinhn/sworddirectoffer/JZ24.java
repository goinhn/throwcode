package com.goinhn.sworddirectoffer;


import java.util.ArrayList;

/**
 * <p>
 * 二叉树中和为某一值的路径
 * <p>
 * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * </p>
 *
 * @author goinhn
 * @date 2020-12-13T20:10:41
 */
public class JZ24 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
    private ArrayList<Integer> listSub = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return listAll;
        }

        listSub.add(root.val);
        target -= root.val;
//        终止的条件，最后目标值为0，且为叶子节点
        if (target == 0 && root.left == null && root.right == null) {
            listAll.add(new ArrayList<>(listSub));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
//        最后要删除当前位置放入的值，回溯的过程
        listSub.remove(listSub.size() - 1);

        return listAll;
    }
}
