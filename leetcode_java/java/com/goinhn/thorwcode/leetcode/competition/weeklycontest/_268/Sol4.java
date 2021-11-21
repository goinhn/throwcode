package com.goinhn.thorwcode.leetcode.competition.weeklycontest._268;

import java.util.ArrayList;
import java.util.List;

/**
 * @author goinhn
 * @date 2021/11/21
 */
public class Sol4 {

    private static class Solution1 {
        private List<Integer> list = new ArrayList<>();

        public long kMirror(int k, int n) {
            int sum = 0;
            int count = 0;
            int num = 1;
            while (count < n) {
                if (isSymmetry(String.valueOf(num))) {
//                    StringBuilder kNum = new StringBuilder();
//                    int tempNum = num;
//                    while (tempNum > 0) {
//                        kNum.append(tempNum % k);
//                        tempNum = tempNum / k;
//                    }

                    if (isSymmetry(Integer.toString(num, k))) {
                        sum += num;
                        count++;
                    }
                }
                num++;
            }
            return sum;
        }

        private boolean isSymmetry(String str) {
            int left = 0;
            int right = str.length() - 1;
            while (left < right) {
                if (str.charAt(left) != str.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }

    private static class Solution2 {
        private List<Integer> list = new ArrayList<>();

        public long kMirror(int k, int n) {
            int sum = 0;
            int count = 0;
            for (Integer integer : list) {
                if (isSymmetry(Integer.toString(integer, k))) {
                    sum += integer;
                    count++;
                }
            }

            int num = list.size() == 0 ? 1 : list.get(list.size() - 1) + 1;
            while (count < n) {
                if (isSymmetry(String.valueOf(num))) {
                    list.add(num);
                    if (isSymmetry(Integer.toString(num, k))) {
                        sum += num;
                        count++;
                    }
                }
                num++;
            }
            return sum;
        }

        private boolean isSymmetry(String str) {
            int left = 0;
            int right = str.length() - 1;
            while (left < right) {
                if (str.charAt(left) != str.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
}
