package com.goinhn.thorwcode.leetcode.competition.biweeklycontest._66;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author goinhn
 * @date 2021/11/27
 */
public class Sol1 {

    private static class Solution1 {
        public int countWords(String[] words1, String[] words2) {
            List<String> strs1 = getListHelper(words1);
            List<String> strs2 = getListHelper(words2);
            return (int) strs1.stream().filter(strs2::contains).count();
        }

        private List<String> getListHelper(String[] words) {
            Map<String, Integer> strMap = new HashMap<>();
            for (String s : words) {
                strMap.put(s, strMap.getOrDefault(s, 0) + 1);
            }
            return strMap.keySet().stream().filter(x -> strMap.get(x) == 1).collect(Collectors.toList());
        }
    }
}
