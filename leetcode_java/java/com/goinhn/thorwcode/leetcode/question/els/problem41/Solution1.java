package com.goinhn.thorwcode.leetcode.question.els.problem41;

import java.util.Arrays;

public class Solution1 {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        if (length == 0 || nums == null) {
            return 1;
        }
        Arrays.sort(nums);
        
        if (nums[0] > 1 || nums[length-1] < 1) {
            return 1;
        }
        
        for (int i = 1; i < length - 1; i++) {
            if (nums[i] < 1) {
                continue;
            } else if (nums[i] == 1) {
                if (nums[i + 1] - nums[i] > 1) {
                    return 2;
                }

            } else if (nums[i] > 1) {
                if (nums[i + 1] - nums[i] > 1 && nums[i-1] >= 1) {
                    return nums[i] + 1;
                }else if(nums[i-1] < 1){
                    return 1;
                }
            }
        }

        return nums[length-1]+1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1000,-1};

        System.out.println(new com.goinhn.leetcode.Solution1().firstMissingPositive(nums));
    }
}