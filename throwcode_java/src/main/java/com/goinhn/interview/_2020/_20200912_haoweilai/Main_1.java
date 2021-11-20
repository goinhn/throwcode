package com.goinhn.interview._2020._20200912_haoweilai;

/**
 * <p>
 * 好未来测试开发工程师笔试
 * <p>
 * 爬楼梯
 * </p>
 *
 * @author goinhn
 * @date 2020-09-12T14:31:15
 */
public class Main_1 {

    /**
     * 递归方法实现
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public static int climbStair(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
