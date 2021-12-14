package com.goinhn.thorwcode.leetcode.question._201_300;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 252.会议室
 *
 * @author goinhn
 * @date 2021/12/14
 */
public class Sol252 {

    /**
     * 先排序，后比较
     * time:O(nlogn)
     * space:O(1)
     */
    private static class Solution1 {
        public boolean canAttendMeetings(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            for (int i = 0; i < intervals.length - 1; i++) {
                if (intervals[i][1] > intervals[i + 1][0]) {
                    return false;
                }
            }
            return true;
        }
    }
}
