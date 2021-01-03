package com.goinhn.leetcode._1_100._1_10;

import java.util.HashSet;
import java.util.Set;

/**
 * 滑动窗口
 */
public class Solution3_3 {

    public static void main(String[] args) {
        String test = "abcabcbb";
        System.out.println(new Solution3_3().lengthOfLongestSubstring(test));
    }

    public int lengthOfLongestSubstring(String s) {
        int strLength = s.length();
        int start = 0, end = 0;
        int maxLength = 0;
        Set<Character> set = new HashSet<>();

        while(start < strLength && end < strLength && maxLength < strLength - start - 1) {
            if(!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                end++;
                maxLength = Math.max(maxLength, end - start);

            }else {
                set.remove(s.charAt(start));
                start++;
            }
        }

        return maxLength;
    }

}
