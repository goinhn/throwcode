package com.goinhn.thorwcode.leetcode.question._201_300;

import java.util.HashMap;
import java.util.Map;

/**
 * 205.同构字符串
 *
 * @author goinhn
 * @date 2021/12/8
 */
public class Sol205 {

    /**
     * 哈希表
     * <p>
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {
        public boolean isIsomorphic(String s, String t) {
            Map<Character, Character> sMap = new HashMap<>();
            Map<Character, Character> tMap = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                Character anotherT = sMap.get(s.charAt(i));
                Character anotherS = tMap.get(t.charAt(i));
                if (null == anotherT && null == anotherS) {
                    sMap.put(s.charAt(i), t.charAt(i));
                    tMap.put(t.charAt(i), s.charAt(i));
                } else if (anotherT == null || anotherS == null) {
                    return false;
                } else if (t.charAt(i) != anotherT || anotherS != s.charAt(i)) {
                    return false;
                }
            }
            return true;
        }
    }
}
