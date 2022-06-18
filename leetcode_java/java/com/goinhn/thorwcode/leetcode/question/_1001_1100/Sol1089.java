package com.goinhn.thorwcode.leetcode.question._1001_1100;

/**
 * 1089.复写零
 *
 * @author goinhn
 * @date 2022/6/17
 */
public class Sol1089 {

    /**
     * 临时数组
     *
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {

        public void duplicateZeros(int[] arr) {
            if (arr == null || arr.length == 0) {
                return;
            }

            int index = 0;
            int[] tempArr = new int[arr.length];
            for (int i = 0; i < arr.length && index < arr.length; i++) {
                if (arr[i] == 0 && index < arr.length - 1) {
                    tempArr[index++] = 0;
                    tempArr[index++] = 0;
                } else {
                    tempArr[index++] = arr[i];
                }
            }

            System.arraycopy(tempArr, 0, arr, 0, arr.length);
        }

    }

    /**
     * 双指针
     *
     * time:O(n)
     * space:O(1)
     */
    private static class Solution2 {

        public void duplicateZeros(int[] arr) {
           if (arr == null || arr.length == 0) {
               return;
           }

           int slow = 0;
           int fast = 0;
           while(fast < arr.length) {
               if (arr[slow] == 0) {
                   fast++;
               }
               slow++;
               fast++;
           }

           slow--;
           fast--;
           while(slow > -1) {
               if (fast < arr.length) {
                   arr[fast] = arr[slow];
               }
               if (arr[slow] == 0 && --fast > -1) {
                   arr[fast] = 0;
               }
               slow--;
               fast--;
           }
        }

    }

}
