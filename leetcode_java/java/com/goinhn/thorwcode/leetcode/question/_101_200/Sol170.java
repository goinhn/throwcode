package com.goinhn.thorwcode.leetcode.question._101_200;

import java.util.ArrayList;
import java.util.List;

/**
 * 170.两数之和III 数据结构设计
 *
 * @author goinhn
 * @date 2021/11/30
 */
public class Sol170 {

    private static class Solution1 {
        public static class TwoSum {
            //属性
            private List<Integer> nums;

            public TwoSum() {
                nums = new ArrayList<>();
            }

            public void add(int number) {
                int index = 0;
                while (index < nums.size()) {
                    if (number < nums.get(index)) {
                        break;
                    }
                    index++;
                }
                nums.add(index, number);
            }

            public boolean find(int value) {
                int left = 0;
                int right = nums.size() - 1;
                while (left < right) {
                    if (nums.get(left) + nums.get(right) < value) {
                        left++;
                    } else if (nums.get(left) + nums.get(right) > value) {
                        right--;
                    } else {
                        return true;
                    }
                }
                return false;
            }
        }
    }
}
