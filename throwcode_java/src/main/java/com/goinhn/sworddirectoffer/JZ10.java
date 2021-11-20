package com.goinhn.sworddirectoffer;

/**
 * <p>
 * 矩阵覆盖
 * <p>
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * </p>
 *
 * @author goinhn
 * @date 2020-12-09T11:59:00
 */
public class JZ10 {

    /**
     * 类似于跳台阶，迭代问题
     *
     * @param target
     * @return
     */
    public int rectCover(int target) {
        if (target < 1) {
            return 0;
        }

        if (target < 3) {
            return target;
        }

        return rectCover(target - 1) + rectCover(target - 2);
    }

    public int rectCoverOfficial(int target) {
        if (target < 1) {
            return 0;
        }

        if (target < 3) {
            return target;
        }

        int first = 1, second = 2, third = 0;
        for (int i = 3; i < target + 1; i++) {
            third = first + second;
            first = second;
            second = third;
        }

        return third;
    }

}
