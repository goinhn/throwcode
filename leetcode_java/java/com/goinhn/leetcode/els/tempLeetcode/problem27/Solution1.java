public class Solution1 {
    public int removeElement(int[] nums, int val) {
        int end = nums.length;

        for(int i =0;i<end;i++){
            if(nums[i] == val){
                int middle = nums[i];
                nums[i] = nums[end-1];
                nums[end-1] = middle;

                end--;
                i--;
            }
        }

        return end;
    }

    public static void main(String[] args) {
        int[] number = { 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 5, 6, 7, 8 };

        System.out.println(new com.goinhn.leetcode.Solution1().removeElement(number,3));
    }
}