package com.goinhn.leetcode._1_100;

//单纯的利用指针比较查找两个数组的情况
public class Solution4_1 {

    public static void main(String[] args) {

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return centerNumber(nums2);
        }

        if (nums2 == null || nums2.length == 0) {
            return centerNumber(nums1);
        }

        int[] newArray = new int[nums1.length + nums2.length];
        int i = 0, j = 0;
        int index = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                newArray[index++] = nums1[i++];
            } else {
                newArray[index++] = nums2[j++];
            }
        }

        if (i < nums1.length) {
            System.arraycopy(nums1, i, newArray, index, nums1.length - i);
        }

        if (j < nums2.length) {
            System.arraycopy(nums2, j, newArray, index, nums2.length - j);
        }

        return centerNumber(newArray);
    }

    public double centerNumber(int[] tempArray) {
        int arrayLength = tempArray.length;
        if (tempArray.length % 2 == 0) {
            return ((double) tempArray[arrayLength / 2 - 1] + (double) tempArray[arrayLength / 2]) / 2;
        } else {
            return (double) tempArray[arrayLength / 2];
        }
    }


}
