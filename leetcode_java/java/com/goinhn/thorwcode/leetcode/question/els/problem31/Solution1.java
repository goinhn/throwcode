//public class Solution1 {
//    // public void nextPermutation(int[] nums) {
//    //     int right = 0;
//    //     boolean flag = false;
//
//    //     for (int i = 1; i < nums.length - 1; i++) {
//    //         if (nums[i] > nums[i + 1]) {
//    //             right = i;
//    //             flag = true;
//    //         }
//    //     }
//
//    //     if (flag) {
//    //         if (right == 0) {
//    //             int middle = nums[right];
//    //             nums[right] = nums[right + 1];
//    //             nums[right + 1] = middle;
//    //         } else {
//    //             int middle = nums[right];
//    //             nums[right] = nums[right - 1];
//    //             nums[right - 1] = middle;
//    //             quickSort(nums, right, nums.length - 1);
//    //         }
//    //     } else {
//    //         for (int i = nums.length - 1; i > 0; i--) {
//    //             if (nums[i] > nums[i - 1]) {
//    //                 int middle = nums[i];
//    //                 nums[i] = nums[i - 1];
//    //                 nums[i - 1] = middle;
//    //                 break;
//    //             }
//    //         }
//    //     }
//    // }
//
//
//    // 快速排序
//    // public int[] quickSort(int[] nums, int begin, int end) {
//    //     int left = begin;
//    //     int right = end;
//
//    //     if (left == right) {
//    //         return nums;
//    //     } else {
//    //         while (left < right) {
//    //             while (left < right) {
//    //                 if (nums[left] <= nums[left + 1]) {
//    //                     left++;
//    //                 } else {
//    //                     break;
//    //                 }
//    //             }
//    //             while (left < right) {
//    //                 if (nums[right] <= nums[right - 1]) {
//    //                     right--;
//    //                 } else {
//    //                     break;
//    //                 }
//    //             }
//    //             if (left < right) {
//    //                 int middle = nums[right];
//    //                 nums[right] = nums[left];
//    //                 nums[left] = middle;
//    //             }
//    //         }
//
//    //         quickSort(nums, begin, left - 1);
//    //         quickSort(nums, right, end);
//    //     }
//
//    //     return nums;
//    // }
//
//    public static void main(String[] args) {
//        com.goinhn.leetcode.Solution1 str = new com.goinhn.leetcode.Solution1();
//
//        int[] nums = { 1,2,3,4,3,2,1 };
//
//        nums = str.quickSort(nums, 0, nums.length-1);
//
//        for (int each : nums) {
//            System.out.println(each);
//        }
//    }
//}