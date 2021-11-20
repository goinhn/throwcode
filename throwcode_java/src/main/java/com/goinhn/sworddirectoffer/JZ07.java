package com.goinhn.sworddirectoffer;

/**
 * <p>
 * 斐波那契数列
 * </p>
 *
 * @author goinhn
 * @date 2020-12-04T12:15:42
 */
public class JZ07 {

    public static void main(String[] args) {
        System.out.println(new JZ07().fibonacci(Integer.MAX_VALUE));
    }

    /**
     * 递归的方式进行实现
     *
     * @param n
     * @return
     */
    public int fibonacci(int n) {
        if (n < 1) {
            return 0;
        }

        if (n < 3) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * 使用迭代的方式进行实现
     *
     * @param n
     * @return
     */
    public int fibonacciOfficial(int n) {
        if (n < 1) {
            return 0;
        }

        if (n < 3) {
            return 1;
        }

        int first = 1, second = 1, third = 0;
        for (int i = 3; i < n + 1; i++) {
            third = first + second;
            first = second;
            second = third;
        }

        return third;
    }

}
