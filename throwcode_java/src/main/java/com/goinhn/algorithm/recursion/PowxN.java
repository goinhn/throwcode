package com.goinhn.algorithm.recursion;

/**
 * <p>
 * leetcode 50
 * <p>
 * 实现pow(x, n)，即计算 x 的 n 次幂函数。
 * <p>
 * 示例 1:
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * <p>
 * 示例2:
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * <p>
 * 示例3:
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 * -100.0 <x< 100.0
 * n是 32 位有符号整数，其数值范围是[−231,231− 1] 。
 * </p>
 *
 * @author goinhn
 * @date 2020-12-21T23:12:51
 */
public class PowxN {

    public double myPow(double x, int n) {
        if (isZero(x) && n < 0) {
            throw new IllegalArgumentException();
        }

        boolean flag = n > 0;
        n = Math.abs(n);

        return flag ? pow(x, n) : 1 / pow(x, n);
    }

    /**
     * 递归计算阶乘
     *
     * @param x
     * @param n
     * @return
     */
    public double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        boolean isEven = n % 2 == 0;
        double half = pow(x, n / 2);
        if (isEven) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    /**
     * 计算浮点数是否为0
     *
     * @param x
     * @return
     */
    public boolean isZero(double x) {
        return x < 0.0000000001 && x > -0.0000000001;
    }

}
