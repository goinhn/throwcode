package com.goinhn.leetcode._1_100._1_10;

import java.util.HashSet;
import java.util.Set;

/**
 * 暴力法，三遍循环
 */
public class Solution3_2 {

    public static void main(String[] args) {
        String test = "abdcdkafkajfkahfkh";
        System.out.println(new Solution3_2().lengthOfLongestSubstring(test));
    }

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() ==0) {
            return 0;
        }

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (allUnique(s, i, j)) {
                    maxLength = Math.max(maxLength, j - i);
                }
            }
        }

        return maxLength;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            if (set.contains(s.charAt(i))) {
                return false;
            }
            set.add(s.charAt(i));
        }
        return true;
    }

}
