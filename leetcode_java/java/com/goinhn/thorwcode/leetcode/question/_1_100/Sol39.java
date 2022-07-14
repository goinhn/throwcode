package com.goinhn.thorwcode.leetcode.question._1_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 39.组合总和
 *
 * @author goinhn
 * @date 2022/7/14
 */
public class Sol39 {

    /**
     * 搜索+回溯
     * time:O(S)
     * space:O(S)
     */
    private static class Solution1 {

        private List<List<Integer>> resList;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            resList = new ArrayList<>();

            for (int i = 0; i < candidates.length; i++) {
                List<Integer> nowList = new ArrayList<>();
                dfs(candidates, target, i, 0, nowList);
            }

            return resList;
        }

        private void dfs(int[] candidates, int target, int index, int nowNum, List<Integer> nowList) {
            if (index >= candidates.length) {
                return;
            }

            nowNum += candidates[index];
            if (nowNum < target) {
                nowList.add(candidates[index]);
                for (int i = index; i < candidates.length; i++) {
                    List<Integer> nextNowList = new ArrayList<>(nowList);
                    dfs(candidates, target, i, nowNum, nextNowList);
                }
            } else if (nowNum > target) {
                return;
            } else {
                nowList.add(candidates[index]);
                resList.add(nowList);
                return;
            }
        }

    }

}
