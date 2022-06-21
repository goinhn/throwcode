package com.goinhn.thorwcode.leetcode.question._1_100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 3.无重复字符最长子串
 *
 * @author goinhn
 * @date 2022/6/21
 */
public class Sol3 {

    /**
     * 左右指针滑动窗口
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {

        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            // 左右指针
            int leftIndex = 0;
            int rightIndex = 1;

            // 记录不重复的相邻位置和元素
            Map<Character, Integer> charMap = new HashMap<>();
            charMap.put(s.charAt(0), 0);
            int max = 1;
            while (rightIndex < s.length() && max < s.length() - leftIndex) {
                if (!charMap.containsKey(s.charAt(rightIndex))) {
                    max = Math.max(max, rightIndex - leftIndex + 1);

                    // 如果右指针存在重复则将左指针跳过重复的位置
                } else {
                    int middleIndex = charMap.get(s.charAt(rightIndex));
                    for (int i = leftIndex; i < middleIndex + 1; i++) {
                        charMap.remove(s.charAt(i));
                    }
                    leftIndex = middleIndex + 1;
                }

                charMap.put(s.charAt(rightIndex), rightIndex);
                rightIndex++;
            }

            return max;
        }

    }

    /**
     * 滑动窗口
     * time:O(n)
     * space:O(n)
     */
    private static class Solution2 {

        public int lengthOfLongestSubstring(String s) {
            int len = s.length();
            int li = 0;
            int ri = 0;
            int max = 0;
            Set<Character> set = new HashSet<>();
            while (ri < len && max < len - li) {
                if (!set.contains(s.charAt(ri))) {
                    set.add(s.charAt(ri));
                    max = Math.max(max, ri - li + 1);
                    ri++;
                } else {
                    set.remove(s.charAt(li));
                    li++;
                }
            }

            return max;
        }

    }

    /**
     * 活动窗口
     * time:O(n)
     * space:O(n)
     */
    private static class Solution3 {

        public int lengthOfLongestSubstring(String s) {
            int li = 0;
            int ri = 0;
            int max = 0;
            Map<Character, Integer> map = new HashMap<>();
            while (ri < s.length()) {
                if (map.containsKey(s.charAt(ri))) {
                    li = Math.max(map.get(s.charAt(ri)), li);
                }

                max = Math.max(max, ri - li + 1);
                map.put(s.charAt(ri), ri + 1);
                ri++;
            }

            return max;
        }
    }

}




























