package com.goinhn.thorwcode.leetcode.competition.biweeklycontest._76;

/**
 * @author goinhn
 * @date 2022/4/16
 */
public class Sol2 {

    private static class Solution1 {
        public long waysToBuyPensPencils(int total, int cost1, int cost2) {
            int count = 0;
            int count1 = 0;
            while(total >= count1 * cost1) {
                int now = total - count1 * cost1;
                count += now / cost2 + 1;
                count1++;
            }

            return count;
        }

        public static void main(String[] args) {
            System.out.println(new Solution1().waysToBuyPensPencils(1000000, 1, 1));
        }
    }
}
