package com.goinhn.thorwcode.leetcode.question._1_100;

/**
 * <p>
 * 4. 寻找两个正序数组的中位数
 * <p>
 * time:O(n)
 * space:O(1)
 * <p>
 * 两个指针去查找总体中间位置的数字
 * </p>
 *
 * @author goinhn
 * @date 2021-06-01
 */
public class Sol_4_1 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return centerArray(nums2);
        }

        if (nums2 == null || nums2.length == 0) {
            return centerArray(nums1);
        }

        int index1 = 0;
        int index2 = 0;
        int length = nums1.length + nums2.length;
        int flagIndex = length / 2;

        if (length % 2 == 0) {
            while(index1 + index2 + 1 < flagIndex) {
                if(nums1[index1] < nums2[index2]) {
                    index1++;
                } else {
                    index2++;
                }
            }
            return (nums1[index1] + nums2[index2]) / 2.0;
        } else {
            while(index1 + index2 + 1 < flagIndex) {
                if(nums1[index1] < nums2[index2]) {
                    index1++;
                } else {
                    index2++;
                }
            }
            return  (double)(Math.min(nums1[index1], nums2[index2]));
        }
    }

    public double centerArray(int[] nums) {
        int length = nums.length;
        return length % 2 == 0 ? (nums[(length - 1) / 2] + nums[length / 2]) / 2.0 : (double) nums[length / 2];
    }

}
