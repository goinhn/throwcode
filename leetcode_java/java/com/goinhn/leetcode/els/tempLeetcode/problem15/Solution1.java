// import java.util.*;

// public class com.goinhn.leetcode.Solution1 {
//     public List<List<Integer>> threeSum(int[] nums) {
//         if(nums.length < 3){
//             return null;
//         }

//         HashSet<Integer> setPositive = new HashSet<>();
//         HashSet<Integer> setNegative = new HashSet<>();
//         boolean zero = false;
        
//         for(int i = 0;i<nums.length;i++){
//             if(nums[i] > 0){
//                 setPositive.add(nums[i]);
//             }else if(nums[i] < 0){
//                 setNegative.add(nums[i]);
//             }else{
//                 zero = true;
//             }
//         }

        

        
//     }

//     public static void main(String[] args){
//         int[] nums = new int[]{2,1,4,5,3,-1,0,8};
//     }
// }