public class Solution1 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int middle = 0;

        while(left <= right){
            middle = (left+right)/2;
            
            if(nums[middle] < target){
                left = middle +1;
            }else if(nums[middle] > target){
                right = middle -1;
            }else{
                return middle;
            }
        }

        if(left > right){
            return left;
        }

        return left;
    }

    public static void main(String[] args){
        int[] nums = {1};

        System.out.println(new com.goinhn.leetcode.Solution1().searchInsert(nums, 23));
    }
}