package com.goinhn.thorwcode.leetcode.question._201_300;

import java.util.HashSet;
import java.util.Set;

/**
 * 217.存在重复元素
 *
 * @author goinhn
 * @date 2021/12/9
 */
public class Sol217 {

    /**
     * 哈希表
     * <p>
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                if (set.contains(num)) {
                    return true;
                }
                set.add(num);
            }
            return false;
        }
    }
}
