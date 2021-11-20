package com.goinhn.thorwcode.leetcode.question._1_100;

/**
 * <p>
 * leetcode 53
 * <p>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释:连续子数组[4,-1,2,1] 的和最大，为6。
 * 进阶:
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * </p>
 *
 * @author goinhn
 * @date 2020-12-22T11:29:18
 */
public class Solution_53_1 {

    /**
     * 动态规划使用一个pre回滚保存前面一个值的大小
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int pre = nums[0];
        int maxNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(nums[i], pre + nums[i]);
            maxNum = Math.max(pre, maxNum);
        }

        return maxNum;
    }

}
