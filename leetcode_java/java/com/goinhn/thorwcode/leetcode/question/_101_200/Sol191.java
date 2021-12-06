package com.goinhn.thorwcode.leetcode.question._101_200;

/**
 * 191.位1的个数
 *
 * @author goinhn
 * @date 2021/12/6
 */
public class Sol191 {

    /**
     * 不断右移计算最右边的位是否为1
     * <p>
     * time:O(1)
     * space:O(1)
     */
    private static class Solution1 {
        public int hammingWeight(int n) {
            int count = 0;
            for (int i = 0; i < 32; i++) {
                count += n & 1;
                n >>>= 1;
            }
            return count;
        }
    }

    /**
     * 利用n & (n - 1)不断消除最后位置的1
     * <p>
     * time:O(1)
     * space:O(1)
     */
    private static class Solution2 {
        public int hammingWeight(int n) {
            int count = 0;
            while (n != 0) {
                n = n & (n - 1);
                count++;
            }
            return count;
        }
    }
}
