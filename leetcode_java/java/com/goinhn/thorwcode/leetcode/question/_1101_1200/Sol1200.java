package com.goinhn.thorwcode.leetcode.question._1101_1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1200.最小绝对差
 *
 * @author goinhn
 * @date 2022/7/4
 */
public class Sol1200 {

    /**
     * 排序 + 遍历
     * time:O(nlogn)
     * space:O(logn)
     */
    private static class Solution1 {

        public List<List<Integer>> minimumAbsDifference(int[] arr) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(arr);
            int minGap = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length - 1; i++) {
                int gap = arr[i + 1] - arr[i];
                if (gap < minGap) {
                    res = new ArrayList<>();
                    minGap = gap;
                }
                if(gap == minGap) {
                    List<Integer> innerRes = new ArrayList<>();
                    innerRes.add(arr[i]);
                    innerRes.add(arr[i + 1]);
                    res.add(innerRes);
                }
            }

            return res;
        }

    }

}
