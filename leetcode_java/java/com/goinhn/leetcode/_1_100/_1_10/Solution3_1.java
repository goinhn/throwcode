package com.goinhn.leetcode._1_100._1_10;

import java.util.HashMap;
import java.util.Map;

public class Solution3_1 {

    public static void main(String[] args) {
        String test = "abcabcbbfakfksfhjkhf";
        System.out.println(new Solution3_1().lengthOfLongestSubstring(test));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int maxLength = 0;
        int nowLength = 0;
//        下一次子字符串开始的位置
        int index = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i = index) {
            nowLength = 0;
            map.clear();
            map.put(s.charAt(i), i);
            nowLength++;
            for (int j = i + 1; j < s.length(); j++) {
                if (map.containsKey(s.charAt(j))) {
                    if (j - i > nowLength) {
                        nowLength = j - i;
                    }
                    index = map.get(s.charAt(j)) + 1;
                    break;
                }
                map.put(s.charAt(j), j);
                nowLength++;
            }

            if (nowLength > maxLength) {
                maxLength = nowLength;
            }
            index++;
        }
        return maxLength;
    }
}
