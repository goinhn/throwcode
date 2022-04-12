package com.goinhn.throwcode.codinginterviews.math;

/**
 * 66.构建乘积数组
 *
 * @author goinhn
 * @date 2022/4/12
 */
public class Jz66 {

    /**
     * 借助左右侧临时数组
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {
        public int[] constructArr(int[] a) {
            int[] resultArray = new int[a.length];
            int[] lArray = new int[a.length];
            int[] rArray = new int[a.length];

            for (int i = 0; i < a.length; i++) {
                if (i == 0) {
                    lArray[i] = 1;
                } else {
                    lArray[i] = lArray[i - 1] * a[i - 1];
                }
            }

            for (int j = a.length - 1; j > -1; j--) {
                if (j == a.length - 1) {
                    rArray[j] = 1;
                } else {
                    rArray[j] = rArray[j + 1] * a[j + 1];
                }
            }

            for (int i = 0; i < a.length; i++) {
                resultArray[i] = lArray[i] * rArray[i];
            }

            return resultArray;
        }
    }
}

