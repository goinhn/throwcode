package com.goinhn.thorwcode.leetcode.question._201_300;

import java.util.HashMap;
import java.util.Map;

/**
 * 242.有效的字母异位词
 *
 * @author goinhn
 * @date 2021/12/12
 */
public class Sol242 {

    private static class Solution1 {
        public boolean isAnagram(String s, String t) {
            Map<Character, Integer> charMap = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                charMap.put(s.charAt(i), charMap.getOrDefault(s.charAt(i), 0) + 1);
            }
            for (int i = 0; i < t.length(); i++) {
                Integer count = charMap.get(t.charAt(i));
                if (count == null || count == 0) {
                    return false;
                } else {
                    charMap.put(t.charAt(i), count - 1);
                }
            }
            for (Integer value : charMap.values()) {
                if (value != 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
