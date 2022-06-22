package com.goinhn.thorwcode.leetcode.question._101_200;

/**
 * 121.买卖股票的最佳时机
 *
 * @author goinhn
 * @date 2021/11/23
 */
public class Sol121 {

    /**
     * time:(n)
     * space:(1)
     */
    private static class Solution1 {

        public int maxProfit(int[] prices) {
            int minPrice = Integer.MAX_VALUE;
            int maxGap = 0;
            for (int price : prices) {
                if (price < minPrice) {
                    minPrice = price;
                } else {
                    maxGap = Math.max(maxGap, price - minPrice);
                }
            }

            return maxGap;
        }

    }

}
