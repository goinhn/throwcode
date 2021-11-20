package com.goinhn.thorwcode.leetcode.question._1_100;

import java.util.regex.*;

/**
 * 利用正则表达式进行匹配，在时间和空间方面达到最快
 */
public class Solution8_2 {

    public static void main(String[] args) {

    }

    public int myAtoi(String str) {
        str = str.trim();
        //java正则表达式
        Pattern p = Pattern.compile("^[\\+\\-]?\\d+");
        Matcher m = p.matcher(str);
        int value = 0;
        //判断是否能匹配
        if (m.find()) {
            //字符串转整数，溢出
            try {
                value = Integer.parseInt(str.substring(m.start(), m.end()));
            } catch (Exception e) {
                //由于有的字符串"42"没有正号，所以我们判断'-'
                value = str.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return value;
    }

}
