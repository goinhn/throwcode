package com.goinhn.throwcode.codinginterviews.pointer;

/**
 * 21.调整数组的顺序使奇数位于偶数前面
 *
 * @author goinhn
 * @date 2020-12-04T23:44:02
 */
public class Jz21 {

    /**
     * 找出奇数和偶数的区分位置
     * time:O(n)
     * space:O(n)
     */
    private static class Solution1 {
        public int[] exchange(int[] nums) {
            if (nums == null || nums.length < 2) {
                return nums;
            }

            int oddCount = 0;
            for (int num : nums) {
                if ((num & 1) == 1) {
                    oddCount++;
                }
            }

            int oddBegin = 0;
            int[] newArray = new int[nums.length];
            for (int num : nums) {
                if ((num & 1) == 1) {
                    newArray[oddBegin++] = num;
                } else {
                    newArray[oddCount++] = num;
                }
            }
            return newArray;
        }
    }

    /**
     * 快慢指针
     * time:O(n)
     * space:O(1)
     */
    private static class Solution2 {
        public int[] exchange(int[] nums) {
            if (nums == null || nums.length < 2) {
                return nums;
            }

            for (int i = 0; i < nums.length; i++) {
                if ((nums[i] & 1) == 0) {
                    int j = i + 1;
                    while (j < nums.length && (nums[j] & 1) == 0) {
                        j++;
                    }
                    if (j < nums.length) {
                        int temp = nums[j];
                        System.arraycopy(nums, i, nums, i + 1, j - i);
                        nums[i] = temp;
                    }
                }
            }
            return nums;
        }
    }

    /**
     * 双端指针
     * time:O(n)
     * space:O(1)
     */
    private static class Solution3 {
        public int[] exchange(int[] nums) {
            if (nums == null || nums.length < 2) {
                return nums;
            }
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                if ((nums[left] & 1) == 1) {
                    left++;
                } else if ((nums[right] & 1) == 0) {
                    right--;
                } else {
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                }
            }
            return nums;
        }
    }

}
