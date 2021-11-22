package com.goinhn.thorwcode.leetcode.question._101_200;

import java.util.ArrayList;
import java.util.List;

/**
 * 118.杨辉三角
 *
 * @author goinhn
 * @date 2021/11/22
 */
public class Sol118 {

    /**
     * 错位相加
     * <p>
     * time:O(n^2)
     * space:O(n^2)
     */
    private static class Solution1 {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> allList = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                List<Integer> list = new ArrayList<>();
                list.add(1);
                if (i - 1 > -1) {
                    List<Integer> preList = allList.get(i - 1);
                    for (int j = 0; j < preList.size(); j++) {
                        list.add(preList.get(j) + (j + 1 >= preList.size() ? 0 : preList.get(j + 1)));
                    }
                }
                allList.add(list);
            }
            return allList;
        }
    }
}
