package com.goinhn.thorwcode.leetcode.question._1_100;

import java.util.HashMap;
import java.util.Map;

/**
 * 13.罗马数字转整数
 *
 * @author goinhn
 * @date 2021-11-04
 **/
public class Sol13 {

    /**
     * 遇到前者罗马字符大于后者罗马字符则加上对应的数值
     * 遇到前者罗马字符小于后者罗马字符则减去对应的数值
     * <p>
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {

        private static final Map<Character, Integer> ROMAN_NUMBER_MAP = new HashMap<>();

        private static void initRomanNumberMap() {
            ROMAN_NUMBER_MAP.put('I', 1);
            ROMAN_NUMBER_MAP.put('V', 5);
            ROMAN_NUMBER_MAP.put('X', 10);
            ROMAN_NUMBER_MAP.put('L', 50);
            ROMAN_NUMBER_MAP.put('C', 100);
            ROMAN_NUMBER_MAP.put('D', 500);
            ROMAN_NUMBER_MAP.put('M', 1000);
        }

        public Solution1() {
            initRomanNumberMap();
        }

        public int romanToInt(String s) {
            int number = 0;
            for (int i = 0; i < s.length() - 1; i++) {
                if (ROMAN_NUMBER_MAP.get(s.charAt(i)) >= ROMAN_NUMBER_MAP.get(s.charAt(i + 1))) {
                    number += ROMAN_NUMBER_MAP.get(s.charAt(i));
                } else {
                    number -= ROMAN_NUMBER_MAP.get(s.charAt(i));
                }
            }
            number += ROMAN_NUMBER_MAP.get(s.charAt(s.length() - 1));

            return number;
        }
    }
}
