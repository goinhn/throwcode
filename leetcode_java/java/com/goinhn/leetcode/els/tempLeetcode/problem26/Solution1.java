public class Solution1 {
    public int removeDuplicates(int[] nums) {
        int begin = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[begin]) {
                begin++;
                nums[begin] = nums[i];
            }
        }

        return begin + 1;
    }

    public static void main(String[] args) {
        int[] number = { 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 5, 6, 7, 8 };

        System.out.println(new com.goinhn.leetcode.Solution1().removeDuplicates(number));
    }

}