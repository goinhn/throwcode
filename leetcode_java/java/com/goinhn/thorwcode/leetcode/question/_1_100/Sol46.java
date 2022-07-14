package com.goinhn.thorwcode.leetcode.question._1_100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 46.全排列
 *
 * @author goinhn
 * @date 2022/7/14
 */
public class Sol46 {

    /**
     * 回溯
     * time:O(n * n!)
     * space:O(n)
     */
    private static class Solution1 {

        private List<List<Integer>> resList;

        public List<List<Integer>> permute(int[] nums) {
            resList = new ArrayList<>();

            List<Integer> numList = new ArrayList<>();
            for (int num : nums) {
                numList.add(num);
            }

            backTrack(numList, 0);

            return resList;
        }

        private void backTrack(List<Integer> numList, int first) {
            if (first == numList.size()) {
                resList.add(new ArrayList<>(numList));
            }

            for (int i = first; i < numList.size(); i++) {
                Collections.swap(numList, i, first);
                backTrack(numList, first + 1);
                Collections.swap(numList, i, first);
            }
        }

    }

}
