package com.goinhn.thorwcode.leetcode.competition.weeklycontest._268;

/**
 * @author goinhn
 * @date 2021/11/21
 */
public class Sol2 {

    private static class Solution1 {
        public int wateringPlants(int[] plants, int capacity) {
            int step = 0;
            int cap = 0;
            for (int i = 0; i < plants.length; i++) {
                if (cap + plants[i] <= capacity) {
                    step++;
                    cap += plants[i];
                } else {
                    step += (i) << 1;
                    cap = 0;
                    i--;
                }
            }
            return step;
        }
    }
}
