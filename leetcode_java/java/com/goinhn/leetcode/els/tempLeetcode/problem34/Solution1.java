public class Solution1 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] { -1, -1 };
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return new int[] { 0, 0 };
            }
        }

        int left = 0;
        int right = nums.length - 1;
        int middle = 0;

        // 二分法进行查找
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                middle = mid;
                break;
            }
        }

        if (left > right) {
            return new int[] { -1, -1 };
        } else {
            int lo = middle - 1;
            int hi = middle + 1;

            while (lo >= left) {
                if (nums[lo] != target) {
                    break;
                }
                lo--;
            }
            while (hi <= right) {
                if (nums[hi] != target) {
                    break;
                }
                hi++;
            }

            return new int[] { ++lo, --hi };
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 4 };

        int[] result = new com.goinhn.leetcode.Solution1().searchRange(nums, 4);

        for (int each : result) {
            System.out.println(each);
        }

    }
}