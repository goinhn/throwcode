package com.goinhn.leetcode._201_300._231_240;

/**
 * <p>
 * 给定一个数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 * <p>
 * 进阶：
 * 你能在线性时间复杂度内解决此题吗？
 * <p>
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * </p>
 * time:O(nklogk)
 * space:O(k)
 *
 * @author goinhn
 * @date 2020-12-18T13:36:25
 */
public class Solution_239_1 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 4, 5};
        nums = new Solution_239_1().maxSlidingWindow(nums, 3);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     * 利用堆的结构，但是堆无法删除除了栈顶外的其它的元素，该方法算法复杂度较大
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int begin = 0;
        while (begin + k - 1 < nums.length) {
            int[] temp = new int[k];
            System.arraycopy(nums, begin, temp, 0, k);
            for (int i = 0; i < k; i++) {
                heapInsert(temp, i);
            }
            result[begin++] = temp[0];
        }

        return result;
    }

    public void heapInsert(int[] nums, int index) {
        while (nums[index] > nums[index / 2]) {
            swap(nums, index, index / 2);
            index /= 2;
        }
    }

    public void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }


}
