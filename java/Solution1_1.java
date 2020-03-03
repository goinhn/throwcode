public class Solution1 {
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0 ; i < nums.length; i++) {                     //设置循环对数组进行遍历，第一次循环确定一个家数
            for (int j = i + 1; j < nums.length; j++) {             //第二次循环确定第二个家数，不允许使用重复的同样的数字，从第一个加数之后开始循环
                if (nums[j] == target - nums[i]) {                  
                    return new int[] { i, j };                      //题目假定一个输入对应一个结果，找到则直接输出结果
                }
            }
        }

        throw new IllegalArgumentException("No two sum number");    //非法参数异常，对于输入没有指定的解
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int target = 10;

        int[] result = new Solution1().twoSum(nums, target);

        for (int each : result) {
            System.out.println(each);
        }
    }
}