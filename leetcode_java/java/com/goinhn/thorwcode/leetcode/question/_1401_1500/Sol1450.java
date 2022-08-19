package com.goinhn.thorwcode.leetcode.question._1401_1500;

/**
 * 1450.在既定时间做作业的学生人数
 *
 * @author goinhn
 * @date 2022/8/19
 */
public class Sol1450 {

    /**
     * 遍历
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {

        public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
            if (startTime == null || startTime.length == 0 || endTime == null || endTime.length == 0) {
                return 0;
            }

            int count = 0;
            for (int i = 0; i < startTime.length; i++) {
                if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                    count++;
                }
            }

            return count;
        }

    }

}
