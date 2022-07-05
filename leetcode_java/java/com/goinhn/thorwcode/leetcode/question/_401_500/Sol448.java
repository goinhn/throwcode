package com.goinhn.thorwcode.leetcode.question._401_500;

import java.util.ArrayList;
import java.util.List;

/**
 * 448.找到所有数组中消失的数字
 *
 * @author goinhn
 * @date 2022/7/4
 */
public class Sol448 {

    /**
     * 通过哈希映射方式，复用当前数组
     * time:O(n)
     * space:O(1)
     */
    private static class Solution1 {

        public List<Integer> findDisappearedNumbers(int[] nums) {
            int n = nums.length;
            for (int num : nums) {
                num = (num - 1) % n;
                nums[num] += + n;
            }

            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= n) {
                    res.add(i + 1);
                }
            }

            return res;
        }

    }

}
