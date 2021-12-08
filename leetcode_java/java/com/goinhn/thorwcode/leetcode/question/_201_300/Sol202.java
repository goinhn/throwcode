package com.goinhn.thorwcode.leetcode.question._201_300;

import java.util.HashSet;
import java.util.Set;

/**
 * 202.快乐数
 *
 * @author goinhn
 * @date 2021/12/7
 */
public class Sol202 {

    /**
     * 哈希表
     * <p>
     * time:O(logn)
     * space:O(n)
     */
    private static class Solution1 {
        public boolean isHappy(int n) {
            Set<Integer> set = new HashSet<>();
            while (!set.contains(n)) {
                set.add(n);
                n = sumOfSquares(n);
                if (n == 1) {
                    return true;
                }
            }
            return false;
        }

        private int sumOfSquares(int x) {
            int result = 0;
            while (x > 0) {
                int single = x % 10;
                result += single * single;
                x /= 10;
            }
            return result;
        }
    }

    /**
     * 快慢指针
     * <p>
     * time:O(logn)
     * space:(1)
     */
    private static class Solution2 {
        public boolean isHappy(int n) {
            int slowIndex = n;
            int fastIndex = sumOfSquares(slowIndex);
            while (fastIndex != 1 && fastIndex != slowIndex) {
                fastIndex = sumOfSquares(sumOfSquares(fastIndex));
                slowIndex = sumOfSquares(slowIndex);
            }
            return fastIndex == 1;
        }

        private int sumOfSquares(int x) {
            int result = 0;
            while (x > 0) {
                int single = x % 10;
                result += single * single;
                x /= 10;
            }
            return result;
        }
    }
}
