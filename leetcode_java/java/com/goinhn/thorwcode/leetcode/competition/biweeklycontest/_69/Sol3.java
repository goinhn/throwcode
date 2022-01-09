package com.goinhn.thorwcode.leetcode.competition.biweeklycontest._69;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author goinhn
 * @date 2022/01/08
 */
public class Sol3 {

    private static class Solution1 {
        public int longestPalindrome(String[] words) {
            Map<String, Integer> strMap = new HashMap<>();
            int count = 0;
            for (String word : words) {
                String anotherKey = word.substring(1) + word.charAt(0);
                Integer anotherCount = strMap.get(anotherKey);
                if (anotherCount == null) {
                    strMap.put(word, strMap.getOrDefault(word, 0) + 1);
                } else {
                    count++;
                    anotherCount--;
                    if (anotherCount < 1) {
                        strMap.remove(anotherKey);
                    } else {
                        strMap.put(anotherKey, anotherCount);
                    }
                }
            }
            Set<String> keys = strMap.keySet();
            int repeatCount = 0;
            for (String key : keys) {
                if (key.charAt(0) == key.charAt(1)) {
                    repeatCount = Math.max(repeatCount, strMap.get(key));
                }
            }
            return count * 4 + repeatCount * 2;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().longestPalindrome(new String[]{"qo", "fo", "fq", "qf", "fo", "ff", "qq", "qf"
                , "of", "of", "oo", "of", "of", "qf", "qf", "of"}));
    }
}
