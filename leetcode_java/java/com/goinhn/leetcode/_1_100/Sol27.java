/*
 * Copyright (C) 2021 Baidu, Inc. All Rights Reserved.
 */
package com.goinhn.leetcode._1_100;

/**
 * 27.移除元素
 *
 * @author goinhn
 * @date 2021-11-06
 **/
public class Sol27 {

    public int removeElement(int[] nums, int val) {
        int end = nums.length;

        for(int i =0;i<end;i++){
            if(nums[i] == val){
                int middle = nums[i];
                nums[i] = nums[end-1];
                nums[end-1] = middle;

                end--;
                i--;
            }
        }

        return end;
    }
}
