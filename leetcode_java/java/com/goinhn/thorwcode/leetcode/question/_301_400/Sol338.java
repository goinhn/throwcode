package com.goinhn.thorwcode.leetcode.question._301_400;

/**
 * @author goinhn
 * @date 2022/7/1
 */
public class Sol338 {

    private static class Solution1 {

        public int[] countBits(int n) {
            int [] ans = new int[n + 1];
            for (int i = 0; i < n + 1; i++) {
                ans[i] = getOne(i);
            }

            return ans;
        }

        private int getOne(int num) {
            int count = 0;
            while(num > 0) {
                if ((num % 2) == 1) {
                    count++;
                }
                num /= 2;
            }
            return count;
        }

    }

}
