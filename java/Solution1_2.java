import java.util.*;

public class Solution2 {
    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length;i++){                             //定义哈希表，以元素的值为key，元素的位置为value
            map.put(nums[i], i);
        }
        for(int i =0 ;i<nums.length;i++){                              //遍历数组，对于每一个值在哈希表中寻找对应的值使之相加为target目标值
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement)!=i){ //判断条件为该对应值存在且和遍历值不为同一个
                return new int[]{i,map.get(complement)};
            }
        }

        throw new IllegalArgumentException("No two sum");              //非法参数异常，对于输入没有指定的解
    }

    public static void main(String[] args){
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int target = 10;

        int[] result = new Solution2().twoSum(nums, target);

        for (int each : result) {
            System.out.println(each);
        }
    }
}