package com.goinhn.thorwcode.leetcode.question._101_200;

import java.util.ArrayList;
import java.util.List;

/**
 * 119.杨辉三角 II
 *
 * @author goinhn
 * @date 2021/11/23
 */
public class Sol119 {

    /**
     * 滚动数组
     * time:(n^2)
     * space:(n)
     */
    private static class Solution1 {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> preList = new ArrayList<>();
            for (int i = 0; i < rowIndex + 1; i++) {
                List<Integer> list = new ArrayList<>();
                list.add(1);
                if (i - 1 > -1) {
                    for (int j = 0; j < preList.size(); j++) {
                        list.add(preList.get(j) + (j + 1 >= preList.size() ? 0 : preList.get(j + 1)));
                    }
                }
                preList = list;
            }
            return preList;
        }
    }

    /**
     * 线性dp
     * time:O(n^2)
     * space:O(n^2)
     */
    private static class Solution2 {
        public List<Integer> getRow(int rowIndex) {
            int[][] f = new int[rowIndex + 1][rowIndex + 1];
            f[0][0] = 1;
            for (int i = 1; i < rowIndex + 1; i++) {
                f[i][0] = f[i - 1][0];
                for (int j = 1; j <= i; j++) {
                    f[i][j] = f[i - 1][j - 1] + f[i - 1][j];
                }
            }
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < rowIndex + 1; i++) {
                res.add(f[rowIndex][i]);
            }
            return res;
        }
    }

    /**
     * 线性dp退化为一个数组
     * time:O(n^2)
     * space:O(n)
     */
    private static class Solution3 {
        public List<Integer> getRow(int rowIndex) {
            int[] f = new int[rowIndex + 1];
            f[0] = 1;
            for (int i = 1; i < rowIndex + 1; i++) {
                int pre = f[0];
                for (int j = 1; j <= i; j++) {
                    int temp = f[j];
                    f[j] += pre;
                    pre = temp;
                }
            }
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < rowIndex + 1; i++) {
                res.add(f[i]);
            }
            return res;
        }
    }

}
