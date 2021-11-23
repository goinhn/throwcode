package com.goinhn.thorwcode.leetcode.question._101_200;

import java.util.ArrayList;
import java.util.List;

/**
 * @author goinhn
 * @date 2021/11/23
 */
public class Sol119 {

    /**
     * 滚动数组
     * <p>
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
}
