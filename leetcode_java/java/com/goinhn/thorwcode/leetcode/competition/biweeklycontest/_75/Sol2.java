package com.goinhn.thorwcode.leetcode.competition.biweeklycontest._75;

/**
 * @author goinhn
 * @date 2022/4/2
 */
public class Sol2 {

    private static class Solution1 {
        public int triangularSum(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }

            int calCount = nums.length - 3;
            int result = (nums[0] + nums[nums.length - 1]) % 10;
            for (int i = 1; i < nums.length / 2; i++) {
                calCount += 2;
                result += calCount * nums[i];
                result %= 10;
            }

            calCount = nums.length - 3;
            for (int i = nums.length - 2; i > nums.length / 2; i--) {
                calCount += 2;
                result += calCount * nums[i];
                result %= 10;
            }

            if (nums.length % 2 == 1) {
                result += nums[nums.length / 2] * (calCount + 2);
                result %= 10;
            }

            return result;
        }

        public static void main(String[] args) {
            System.out.println(new Solution1().triangularSum(new int[]{2, 6, 6, 5, 5, 3, 3, 8, 6, 4, 3, 3, 5, 1, 0, 1
                    , 3, 6, 9}));
        }
    }

    private static class Solution2 {
        public int triangularSum(int[] nums) {
            for (int i = nums.length - 1; i > -1; i--) {
                for (int j = 0; j < i; j++) {
                    nums[j] = nums[j] + nums[j + 1];
                    nums[j] %= 10;
                }
            }
            return nums[0];
        }

        public static void main(String[] args) {
            System.out.println(new Solution1().triangularSum(new int[]{1,2,3,4,5}));
        }
    }
}
