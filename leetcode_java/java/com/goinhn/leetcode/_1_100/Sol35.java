/*
 * Copyright (C) 2021 Baidu, Inc. All Rights Reserved.
 */
package com.goinhn.leetcode._1_100;

/**
 * @author goinhn
 * @date 2021-11-06
 **/
public class Sol35 {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int middle = 0;

        while(left <= right){
            middle = (left+right)/2;

            if(nums[middle] < target){
                left = middle +1;
            }else if(nums[middle] > target){
                right = middle -1;
            }else{
                return middle;
            }
        }

        if(left > right){
            return left;
        }

        return left;
    }
}
