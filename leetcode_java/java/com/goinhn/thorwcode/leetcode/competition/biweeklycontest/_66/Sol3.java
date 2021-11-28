package com.goinhn.thorwcode.leetcode.competition.biweeklycontest._66;

/**
 * @author goinhn
 * @date 2021/11/27
 */
public class Sol3 {

    private static class Solution1 {
        public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
            int num = 0;
            int rowStep = (homePos[0] < startPos[0]) ? -1 : ((homePos[0] == startPos[0]) ? 0 : 1);
            int colStep = (homePos[1] < startPos[1]) ? -1 : ((homePos[1] == startPos[1]) ? 0 : 1);
            while (startPos[0] != homePos[0] || startPos[1] != homePos[1]) {
                if (rowStep != 0 && startPos[0] != homePos[0]) {
                    num += rowCosts[startPos[0] + rowStep];
                    startPos[0] = startPos[0] + rowStep;
                }
                if (colStep != 0 && startPos[1] != homePos[1]) {
                    num += colCosts[startPos[1] + colStep];
                    startPos[1] = startPos[1] + colStep;
                }
            }
            return num;
        }

        public static void main(String[] args) {
            System.out.println(new Solution1().minCost(new int[]{1, 0}, new int[]{2, 3}, new int[]{5, 4, 3},
                    new int[]{8, 2, 6, 7}));
        }
    }
}
