package com.goinhn.interview._2020._20201010_pinduoduo;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * 拼多多面试
 * <p>
 * 对一棵二叉搜索树实现迭代器的next和hasNext的方法
 * </p>
 *
 * @author goinhn
 * @date 2020-10-11T00:04:46
 */
public class Main_1 {

    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private List<Integer> list;
    private int index;

    public Main_1(TreeNode root) {
        list = new LinkedList<>();
        index = 0;
        init(root);
    }

    public void init(TreeNode root) {
        if (root != null) {
            init(root.left);
            list.add(root.val);
            init(root.right);
        }
    }

    public int next() {
        return list.get(index++);
    }

    public boolean hasNext() {
        return index < list.size();
    }
}
