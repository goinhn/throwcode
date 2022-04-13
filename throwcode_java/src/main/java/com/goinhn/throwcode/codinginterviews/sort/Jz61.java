package com.goinhn.throwcode.codinginterviews.sort;

import java.util.HashSet;
import java.util.Set;

/**
 * 61.扑克牌中的顺子
 *
 * @author goinhn
 * @date 2022/4/13
 */
public class Jz61 {

    /**
     * 哈希+数字大小判断
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {
        public boolean isStraight(int[] nums) {
            Set<Integer> numSet = new HashSet<>();
            int maxNum = Integer.MIN_VALUE;
            int minNum = Integer.MAX_VALUE;
            for (int num : nums) {
                if (num == 0) {
                    continue;
                }
                if (numSet.contains(num)) {
                    return false;
                }
                numSet.add(num);
                maxNum = Math.max(maxNum, num);
                minNum = Math.min(minNum, num);
            }

            return maxNum - minNum < nums.length;
        }
    }
}

