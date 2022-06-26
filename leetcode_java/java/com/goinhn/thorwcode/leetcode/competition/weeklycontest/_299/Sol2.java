package com.goinhn.thorwcode.leetcode.competition.weeklycontest._299;

/**
 * @author goinhn
 * @date 2022/6/26
 */
public class Sol2 {

    /**
     * time:O()
     * space:O()
     */
    private static class Solution1 {

        private static final int CONSTANT_NUM = 1000000000 + 7;

        public int countHousePlacements(int n) {
            if (n == 1) {
                return 4;
            }
            if (n == 2) {
                return 9;
            }

            long a = 2;
            long b = 3;
            for (int i = 2; i < n; i++) {
                long temp = b;
                b = (a + b) % CONSTANT_NUM;
                a = temp;
            }

            return (int) ((b * b) % CONSTANT_NUM);
        }

        public static void main(String[] args) {
            System.out.println(new Solution1().countHousePlacements(1000));
        }


    }

}
