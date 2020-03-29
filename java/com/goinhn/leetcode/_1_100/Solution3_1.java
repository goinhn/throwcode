package com.goinhn.leetcode._1_100;

import java.util.HashMap;
import java.util.Map;

public class Solution3_1 {

    public static void main(String[] args) {
        String test = "abcabcbb";
        System.out.println(new Solution3_1().lengthOfLongestSubstring(test));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int maxLength = 0;
        int nowLength = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            nowLength = 0;
            map.clear();
            map.put(s.charAt(i), i);
            nowLength++;
            for (int j = i + 1; j < s.length(); j++) {
                if (map.containsKey(s.charAt(j))) {
                    if (j - i > nowLength) {
                        nowLength = j - i;
                    }
                    break;
                }
                map.put(s.charAt(j), j);
                nowLength++;
            }
            if(nowLength > maxLength){
                maxLength = nowLength;
            }
        }
        return maxLength;
    }
}
