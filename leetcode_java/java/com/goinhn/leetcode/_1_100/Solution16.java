package com.goinhn.leetcode._1_100;

import java.util.Arrays;

public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        if (nums == null || len < 3) {
            return 0;
        }

        Arrays.sort(nums);
        int finallySum = nums[0]+nums[1]+nums[2];
        int minNumber = Math.abs(finallySum - target);
        
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int begin = i + 1;
            int end = len - 1;
            int sum = 0;
            while (begin < end) {
                sum = (nums[i] + nums[begin] + nums[end]);

                if (Math.abs(sum - target) < minNumber) {
                    minNumber = Math.abs(sum - target);
                    finallySum = sum;
                } 
           
                while (begin < end) {
                    begin++;
                    if (nums[begin] != nums[begin - 1]) {
                        break;
                    }
                }
                while (begin < end) {
                    end--;
                    if (nums[end] != nums[end + 1]) {
                        break;
                    }
                }
            }
        }
        return finallySum;
    }
}