package com.goinhn.throwcode.codinginterviews.math;

/**
 * 64.求1+2+…+n
 *
 * @author goinhn
 * @date 2022/6/15
 */
public class Jz64 {

    /**
     * 与运算代替if
     * <p>
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {

        public int sumNums(int n) {
            boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
            return n;
        }

    }

    /**
     * 公式运算
     * <p>
     * time:O(1)
     * space:O(1)
     */
    private static class Solution2 {

        public int sumNums(int n) {
            return (1 + n) * n / 2;
        }

    }

    /**
     * 递归
     * <p>
     * time:O(n)
     * space:O(n)
     */
    private static class Solution3 {

        public int sumNums(int n) {
            if (n < 1) {
                return 0;
            }

            return n + sumNums(n - 1);
        }

    }

}
