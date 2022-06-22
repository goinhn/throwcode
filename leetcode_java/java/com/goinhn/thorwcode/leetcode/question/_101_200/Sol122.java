package com.goinhn.thorwcode.leetcode.question._101_200;

/**
 * 122.买卖股票的最佳时机
 * @author goinhn
 * @date 2020-12-22T12:40:40
 */
public class Sol122 {

    private static class Solution1 {

        public int maxProfit(int[] prices) {
            int result = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                if (prices[i] < prices[i + 1]) {
                    result += prices[i + 1] - prices[i];
                }
            }

            return result;
        }

    }

}
