package com.goinhn.throwcode.codinginterviews.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 57II.和为s的连续正数序列
 *
 * @author goinhn
 * @date 2022/4/20
 */
public class Jz57II {

    /**
     * 暴力遍历
     * time:O(target * sqrt(target))
     * space:O(1)
     */
    private static class Solution1 {
        public int[][] findContinuousSequence(int target) {
            int limit = target / 2;
            List<List<Integer>> list = new ArrayList<>();
            for (int beginNum = 1; beginNum <= limit; beginNum++) {
                int sum = beginNum;
                List<Integer> listInner = new ArrayList<>();
                listInner.add(beginNum);
                for (int accumulateNum = beginNum + 1; sum < target; accumulateNum++) {
                    sum += accumulateNum;
                    listInner.add(accumulateNum);
                    if (sum == target) {
                        list.add(listInner);
                    }
                }
            }

            int[][] result = new int[list.size()][];
            for (int i = 0; i < list.size(); i++) {
                List<Integer> listInner = list.get(i);
                int[] arrayInner = new int[listInner.size()];
                for (int j = 0; j < listInner.size(); j++) {
                    arrayInner[j] = listInner.get(j);
                }
                result[i] = arrayInner;
            }
            return result;
        }
    }

    /**
     * 双指针
     * time:O(target)
     * space:O(1)
     */
    private static class Solution2 {
        public int[][] findContinuousSequence(int target) {
            int limit = target / 2;
            int left = 1;
            int right = 2;
            List<int[]> list = new ArrayList<>();
            while (left <= limit) {
                int sum = (left + right) * (right - left + 1) / 2;
                if (sum == target) {
                    int[] arrayTemp = new int[right - left + 1];
                    for (int i = 0; i < arrayTemp.length; i++) {
                        arrayTemp[i] = left + i;
                    }
                    list.add(arrayTemp);
                    left++;
                } else if (sum < target) {
                    right++;
                } else {
                    left++;
                }
            }

            int[][] array = new int[list.size()][];
            for (int i = 0; i < list.size(); i++) {
                array[i] = list.get(i);
            }

            return array;
        }
    }

}
