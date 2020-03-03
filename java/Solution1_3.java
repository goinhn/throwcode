import java.util.*;

public class Solution3 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        //一次循环，在往哈希表中添加元素的同时也检验是否存在符合的解
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(nums[i]) != i) {
                return new int[] { nums[i], complement };
            }
        }

        throw new IllegalArgumentException("No two sum");            //非法参数异常，对于输入没有指定的解
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int target = 10;

        int[] result = new Solution3().twoSum(nums, target);

        for (int each : result) {
            System.out.println(each);
        }
    }
}