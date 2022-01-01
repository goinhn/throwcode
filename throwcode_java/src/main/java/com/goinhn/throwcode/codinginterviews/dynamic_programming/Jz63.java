package com.goinhn.throwcode.codinginterviews.dynamic_programming;

/**
 * 63.股票的最大利润
 *
 * @author goinhn
 * @date 2022/1/1
 */
public class Jz63 {

    /**
     * 暴力法
     * time:O(n^2)
     * space:O(1)
     */
    private static class Solution1 {
        public int maxProfit(int[] prices) {
            int maxGap = 0;
            for (int i = 0; i < prices.length; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    maxGap = Math.max(maxGap, prices[j] - prices[i]);
                }
            }
            return maxGap;
        }
    }

    /**
     * 迭代、动态规划
     * time:O(n)
     * space:O(1)
     */
    private static class Solution2 {
        public int maxProfit(int[] prices) {
            int minNum = Integer.MAX_VALUE;
            int maxGap = 0;
            for (int price : prices) {
                minNum = Math.min(minNum, price);
                maxGap = Math.max(maxGap, price - minNum);
            }
            return maxGap;
        }
    }

}

