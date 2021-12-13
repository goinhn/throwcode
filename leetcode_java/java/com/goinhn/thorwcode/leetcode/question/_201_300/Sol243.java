/*
 * Copyright (C) 2021 Baidu, Inc. All Rights Reserved.
 */
package com.goinhn.thorwcode.leetcode.question._201_300;

import java.util.ArrayList;
import java.util.List;

/**
 * 243.最短单词距离
 *
 * @author fangwenzhan
 * @date 2021/12/13
 */
public class Sol243 {

    /**
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {
        public int shortestDistance(String[] words, String word1, String word2) {
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1)) {
                    list1.add(i);
                }
                if (words[i].equals(word2)) {
                    list2.add(i);
                }
            }

            int i = 0, j = 0;
            int min = Integer.MAX_VALUE;
            int w1Index;
            int w2Index;
            while (i < list1.size() && j < list2.size()) {
                w1Index = list1.get(i);
                w2Index = list2.get(j);
                min = Math.min(Math.abs(w1Index - w2Index), min);
                if (w1Index < w2Index) {
                    i++;
                }
                if (w2Index < w1Index) {
                    j++;
                }
            }
            return min;
        }
    }
}
