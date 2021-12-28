package com.goinhn.throwcode.codinginterviews.find;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 50.第一个只出现一次的字符
 *
 * @author goinhn
 * @date 2021/12/27
 */
public class Jz50 {

    /**
     * 哈希表
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {
        public char firstUniqChar(String s) {
            if (s == null) {
                return ' ';
            }

            Map<Character, Boolean> countMap = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                Boolean isExist = countMap.get(s.charAt(i));
                if (isExist == null) {
                    countMap.put(s.charAt(i), Boolean.TRUE);
                } else {
                    countMap.put(s.charAt(i), Boolean.FALSE);
                }
            }

            for (int i = 0; i < s.length(); i++) {
                if (countMap.get(s.charAt(i))) {
                    return s.charAt(i);
                }
            }

            return ' ';
        }
    }

    /**
     * 有序哈希表
     * time:O(n)
     * space:O(n)
     */
    private static class Solution2 {
        public char firstUniqChar(String s) {
            if (s == null) {
                return ' ';
            }

            Map<Character, Boolean> countMap = new LinkedHashMap<>();
            for (int i = 0; i < s.length(); i++) {
                Boolean isExist = countMap.get(s.charAt(i));
                if (isExist == null) {
                    countMap.put(s.charAt(i), Boolean.TRUE);
                } else {
                    countMap.put(s.charAt(i), Boolean.FALSE);
                }
            }

            Set<Character> keySet = countMap.keySet();
            for (Character character : keySet) {
                if (countMap.get(character)) {
                    return character;
                }
            }

            return ' ';
        }
    }
}

