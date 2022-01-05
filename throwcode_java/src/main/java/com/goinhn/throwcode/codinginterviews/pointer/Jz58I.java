package com.goinhn.throwcode.codinginterviews.pointer;

/**
 * 58I.翻转单词顺序
 *
 * @author goinhn
 * @date 2022/1/5
 */
public class Jz58I {


    private static class Solution1 {
        public String reverseWords(String s) {
            if (s == null) {
                return null;
            }
            s = s.trim();
            String[] sArray = s.split("\\s+");
            int left = 0;
            int right = sArray.length - 1;
            while (left < right) {
                String sTemp = sArray[left];
                sArray[left] = sArray[right];
                sArray[right] = sTemp;
                left++;
                right--;
            }
            return String.join(" ", sArray);
        }
    }
}

