package com.goinhn.thorwcode.leetcode.question._401_500;

/**
 * 461.汉明距离
 *
 * @author goinhn
 * @date 2022/7/5
 */
public class Sol461 {

    /**
     * 异或移位操作
     * <p>
     * time:O(logC)
     * space:O(1)
     */
    private static class Solution1 {

        public int hammingDistance(int x, int y) {
            x ^= y;
            int count = 0;
            while (x > 0) {
                count += x & 1;
                x >>= 1;
            }

            return count;
        }

    }

    /**
     * 内置函数
     * time:O(1)
     * space:O(1)
     */
    private static class Solution2 {

        public int hammingDistance(int x, int y) {
            return Integer.bitCount(x ^ y);
        }

    }

    /**
     * Brian Kernighan
     * time:O(logC)
     * space:O(1)
     */
    private static class Solution3 {

        public int hammingDistance(int x, int y) {
            int num = x ^ y;
            int ans = 0;
            while (num != 0) {
                ans += 1;
                num &= (num - 1);
            }
            return ans;
        }

    }

}
