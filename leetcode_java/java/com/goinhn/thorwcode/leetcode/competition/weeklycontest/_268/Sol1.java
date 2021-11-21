package com.goinhn.thorwcode.leetcode.competition.weeklycontest._268;

/**
 * @author goinhn
 * @date 2021/11/21
 */
public class Sol1 {

    private static class Solution1 {
        public int maxDistance(int[] colors) {
            int result = 0;
            for (int i = 0; i < colors.length; i++) {
                for (int j = i + 1; j < colors.length; j++) {
                    int distance = colors[i] == colors[j] ? 0 : j - i;
                    result = Math.max(result, distance);
                }
            }
            return result;
        }
    }
}
