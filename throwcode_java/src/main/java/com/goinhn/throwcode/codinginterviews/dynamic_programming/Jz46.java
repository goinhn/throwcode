package com.goinhn.throwcode.codinginterviews.dynamic_programming;

/**
 * 46.把数字翻译成字符串
 *
 * @author goinhn
 * @date 2022/1/3
 */
public class Jz46 {

    /**
     * 动态规划
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {
        public int translateNum(int num) {
            String numStr = String.valueOf(num);
            int[] dp = new int[numStr.length() + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i < dp.length; i++) {
                String temp = numStr.substring(i - 2, i);
                dp[i] = temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0
                        ? dp[i - 2] + dp[i - 1]
                        : dp[i - 1];
            }
            return dp[dp.length - 1];
        }
    }

    /**
     * 动态规划，进一步压缩空间
     * time:O(n)
     * space:O(1)
     */
    private static class Solution2 {
        public int translateNum(int num) {
            String numStr = String.valueOf(num);
            int preOne = 1;
            int preTwo = 1;
            for (int i = 0; i < numStr.length() - 1; i++) {
                String temp = numStr.substring(i, i + 2);
                int tempNum = preTwo;
                preTwo = temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0
                        ? preOne + preTwo
                        : preTwo;
                preOne = tempNum;
            }
            return preTwo;
        }

        public static void main(String[] args) {
            System.out.println(new Solution2().translateNum(220));
        }
    }
}

