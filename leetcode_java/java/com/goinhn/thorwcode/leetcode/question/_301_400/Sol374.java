package com.goinhn.thorwcode.leetcode.question._301_400;

import java.util.Random;

/**
 * @author goinhn
 * @date 2022/8/30
 */
public class Sol374 {

    private static class GuessGame {

        public int guess(int num) {
            return new Random().nextInt(3) - 1;
        }

    }

    /**
     * 二分查找
     * time:O(logn)
     * space:O(1)
     */
    private static class Solution1 extends GuessGame {
        public int guessNumber(int n) {
            int l = 1;
            int r = n;
            while (l <= r) {
                int m = l + (r - l) / 2;
                int res = guess(m);
                switch (res) {
                    case -1:
                        r = m - 1;
                        break;
                    case 0:
                        return m;
                    case 1:
                        l = m + 1;
                        break;
                    default:
                        break;
                }
            }

            return -1;
        }
    }

}
