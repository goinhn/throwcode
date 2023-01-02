package com.goinhn.thorwcode.leetcode.question._2001_2100;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 2032.至少在两个数组中出现的值
 *
 * @author goinhn
 * @date 2023/1/1
 */
public class Sol2032 {

    /**
     * 哈希表标记
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {

        public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums1) {
                map.put(num, map.getOrDefault(num, 0) | 1);
            }
            for (int num : nums2) {
                map.put(num, map.getOrDefault(num, 0) | 2);
            }
            for (int num : nums3) {
                map.put(num, map.getOrDefault(num, 0) | 4);
            }
            return map.entrySet().stream()
                    .filter(entry -> (entry.getValue() & entry.getValue() - 1) != 0)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
        }

    }
}
