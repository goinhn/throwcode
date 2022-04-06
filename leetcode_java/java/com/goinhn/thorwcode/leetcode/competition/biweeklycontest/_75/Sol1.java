package com.goinhn.thorwcode.leetcode.competition.biweeklycontest._75;


/**
 * @author goinhn
 * @date 2022/04/02
 */
public class Sol1 {

    private static class Solution1 {
        public int minBitFlips(int start, int goal) {
            return countOne(start ^ goal);
        }

        private int countOne(int num) {
            int count = 0;
            while (num > 0) {
                if (num % 2 == 1) {
                    count++;
                }
                num /= 2;
            }
            return count;
        }

        public static void main(String[] args) {
            System.out.println(new Solution1().minBitFlips(7,10));
        }
    }
}
