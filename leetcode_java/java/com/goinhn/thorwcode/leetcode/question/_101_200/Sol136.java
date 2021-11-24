package com.goinhn.thorwcode.leetcode.question._101_200;

import java.util.HashSet;

/**
 * 136.只出现一次的数字
 *
 * @author goinhn
 * @date 2021/11/24
 */
public class Sol136 {

    /**
     * 利用辅助set
     * <p>
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {
        public int singleNumber(int[] nums) {
            HashSet<Integer> numSet = new HashSet<>();
            for (int num : nums) {
                if (numSet.contains(num)) {
                    numSet.remove(num);
                } else {
                    numSet.add(num);
                }
            }
            return numSet.iterator().next();
        }
    }

    /**
     * 利用异或的属性
     * <p>
     * time:O(n)
     * space:O(1)
     */
    private static class Solution2 {
        public int singleNumber(int[] nums) {
            int result = 0;
            for (int num : nums) {
                result ^= num;
            }
            return result;
        }
    }
}
