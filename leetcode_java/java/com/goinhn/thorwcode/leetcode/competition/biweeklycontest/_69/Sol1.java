package com.goinhn.thorwcode.leetcode.competition.biweeklycontest._69;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author goinhn
 * @date 2022/01/08
 */
public class Sol1 {

    private static class Solution1 {
        public String capitalizeTitle(String title) {
            if (title == null  || title.length() == 0) {
                return title;
            }
            String[] titleArr = title.split(" ");
            return Stream.of(titleArr).map(singleStr -> {
                if (singleStr.length() < 3) {
                    return singleStr.toLowerCase();
                } else {
                    return singleStr.substring(0, 1).toUpperCase() + singleStr.substring(1).toLowerCase();
                }
            }).collect(Collectors.joining(" "));
        }
    }
}
