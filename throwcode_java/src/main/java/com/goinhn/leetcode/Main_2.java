/*
 * Copyright (C) 2021 Baidu, Inc. All Rights Reserved.
 */
package com.goinhn.leetcode;

/**
 * @author fangwenzhan
 * @date 2021-06-06
 */
public class Main_2 {

    public int reductionOperations(int[] nums) {
        int count = 0;
        int largest = Integer.MIN_VALUE;
        int nextLargest = Integer.MIN_VALUE;
        int largestIndex = -1;
        int nextLargestIndex = -1;

        do {
            largestIndex = -1;
            nextLargestIndex = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > largest) {
                    nextLargest = largest;
                    nextLargestIndex = largestIndex;
                    largest = nums[i];
                    largestIndex = i;
                } else if (nums[i] > nextLargest && nums[i] < largestIndex) {
                    nextLargestIndex = i;
                }
            }
            if(nextLargestIndex != -1) {
                nums[largestIndex] = nums[nextLargestIndex];
            }

            count++;
        } while(nextLargestIndex != -1);

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Main_2().reductionOperations(new int[]{5,1,3}));
    }


}
