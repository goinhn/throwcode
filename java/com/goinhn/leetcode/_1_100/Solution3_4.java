package com.goinhn.leetcode._1_100;

import java.util.HashMap;
import java.util.Map;

//使用hashmap优化滑动窗口
public class Solution3_4 {

    public static void main(String[] args) {
        String test = "dvdf";
        System.out.println(new Solution3_4().lengthOfLongestSubstring(test));
    }

    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int strLength = s.length();
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();

        while(right < strLength) {
            if(map.containsKey(s.charAt(right))) {
                left = Math.max(map.get(s.charAt(right)), left);
            }
            maxLength = Math.max(maxLength, right - left + 1);
            map.put(s.charAt(right), right + 1);
            right++;
        }

        return maxLength;
    }


}
