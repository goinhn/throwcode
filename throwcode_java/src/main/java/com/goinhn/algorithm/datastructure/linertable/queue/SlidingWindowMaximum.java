package com.goinhn.algorithm.datastructure.linertable.queue;

import java.util.ArrayDeque;

/**
 * <p>
 * leetcode 239
 *
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
 * time:O(n)
 * space:O(k)
 *
 * @author goinhn
 * @date 2020-12-18T13:36:25
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 4, 5};
        nums = new SlidingWindowMaximum().maxSlidingWindow(nums, 3);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    private ArrayDeque<Integer> deq = new ArrayDeque<>();
    private int[] nums;

    public void cleanDeque(int i, int k) {
        // remove indexes of elements not from sliding window
        if (!deq.isEmpty() && deq.getFirst() == i - k) {
            deq.removeFirst();
        }

        // remove from deq indexes of all elements
        // which are smaller than current element nums[i]
        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]) {
            deq.removeLast();
        }
    }

    /**
     * 使用双向队列
     * 队列最左边的数字是最大的数字，任何在其左边的数字都要被移除
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }

        // init deque and output
        this.nums = nums;
        int maxIndex = 0;
        for (int i = 0; i < k; i++) {
            cleanDeque(i, k);
            deq.addLast(i);
            // compute max in nums[:k]
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        int[] output = new int[n - k + 1];
        output[0] = nums[maxIndex];

        // build output
        for (int i = k; i < n; i++) {
            cleanDeque(i, k);
            deq.addLast(i);
            output[i - k + 1] = nums[deq.getFirst()];
        }
        return output;
    }


}
