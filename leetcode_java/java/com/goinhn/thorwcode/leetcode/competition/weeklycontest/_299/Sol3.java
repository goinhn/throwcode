package com.goinhn.thorwcode.leetcode.competition.weeklycontest._299;

/**
 * @author goinhn
 * @date 2022/6/26
 */
public class Sol3 {

    /**
     * time:O()
     * space:O()
     */
    private static class Solution1 {

        public int maximumsSplicedArray(int[] nums1, int[] nums2) {
            int sum1 = getSum(nums1, 0, nums1.length);
            int sum2 = getSum(nums2, 0, nums2.length);

            if (sum1 < sum2) {
                return getMaxGap(nums2, nums1) + sum2;
            } else {
                return getMaxGap(nums1, nums2) + sum1;
            }
        }

        private int getMaxGap(int[] mai, int[] sub) {
            int gap = 0;
            int n = mai.length;
            int left = -1;
            int right = -1;
            int i = 0;
            while (i < n) {
                if (mai[i] <= sub[i]) {
                    if (i == right + 1) {
                        right++;
                        gap += sub[i] - mai[i];
                    } else {
                        if (left == -1 && right == -1 || sub[i] - mai[i] >= gap) {
                            left = i;
                            right = i;
                            gap = sub[i] - mai[i];
                        } else {
                            int midSubSum = getSum(sub, left, i + 1);
                            int midMaiSum = getSum(sub, left, i + 1);
                            int tempGap = midSubSum - midMaiSum;
                            if (tempGap >= gap) {
                                right = i;
                                gap = tempGap;
                            }
                        }
                    }
                }

                i++;
            }

            return gap;
        }

        private int getSum(int[] nums, int left, int right) {
            int sum = 0;
            for (int i = left; i < right; i++) {
                sum += nums[i];
            }

            return sum;
        }

    }

}
