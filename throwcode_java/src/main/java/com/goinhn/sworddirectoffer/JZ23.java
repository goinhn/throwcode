package com.goinhn.sworddirectoffer;

/**
 * <p>
 * 二叉搜索树的后序遍历
 * <p>
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。
 * </p>
 *
 * @author goinhn
 * @date 2020-12-13T19:39:27
 */
public class JZ23 {

    /**
     * 递归
     * 不断找中间分隔的位置，分隔位置左侧的数字都小于根节点的值，分隔右侧的值都大于根节点的值
     *
     * @param sequence
     * @return
     */
    public boolean verifySequenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }

        return verifyHelper(sequence, 0, sequence.length - 1);
    }

    public boolean verifyHelper(int[] sequence, int left, int right) {
        if(left >= right) {
            return true;
        }

//        寻找分隔的位置
        int spl = right;
        for(int i = left; i < right; i++) {
            if(sequence[i] > sequence[right]) {
                spl = i;
                break;
            }
        }

        for(int i = spl; i < right; i++) {
            if(sequence[i] < sequence[right]) {
                return false;
            }
        }

        return verifyHelper(sequence, left, spl - 1) && verifyHelper(sequence, spl, right - 1);
    }
}
