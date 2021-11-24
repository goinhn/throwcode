//package com.goinhn.thorwcode.leetcode.question.els.problem41;
//
//public class Solution2{
//    public int firstMissingPositive(int[] nums) {
//        int n = nums.length;
//
//        // 基本情况
//        int contains = 0;
//        for (int i = 0; i < n; i++)
//          if (nums[i] == 1) {
//            contains++;
//            break;
//          }
//
//        if (contains == 0)
//          return 1;
//
//        // nums = [1]
//        if (n == 1)
//          return 2;
//
//        // 用 1 替换负数，0，
//        // 和大于 n 的数
//        // 在转换以后，nums 只会包含
//        // 正数
//        for (int i = 0; i < n; i++)
//          if ((nums[i] <= 0) || (nums[i] > n))
//            nums[i] = 1;
//
//        // 使用索引和数字符号作为检查器
//        // 例如，如果 nums[1] 是负数表示在数组中出现了数字 `1`
//        // 如果 nums[2] 是正数 表示数字 2 没有出现
//        for (int i = 0; i < n; i++) {
//          int a = Math.abs(nums[i]);
//          // 如果发现了一个数字 a - 改变第 a 个元素的符号
//          // 注意重复元素只需操作一次
//          if (a == n)
//            nums[0] = - Math.abs(nums[0]);
//          else
//            nums[a] = - Math.abs(nums[a]);
//        }
//
//        // 现在第一个正数的下标
//        // 就是第一个缺失的数
//        for (int i = 1; i < n; i++) {
//          if (nums[i] > 0)
//            return i;
//        }
//
//        if (nums[0] > 0)
//          return n;
//
//        return n + 1;
//      }
//
//
//}