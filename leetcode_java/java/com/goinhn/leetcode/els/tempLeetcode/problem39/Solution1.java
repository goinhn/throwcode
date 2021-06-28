//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class Solution1{
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        ArrayList<Object> list = new ArrayList<>();
//        Arrays.sort(candidates);
//
//        int length = 0;
//        for(int i = 1;i<candidates.length;i++){
//            if(candidates[i] != target && candidates[i-1] == target){
//                length = i;
//                break;
//            }
//        }
//
//        int result = target;
//        for(int i = 0; i < length; i++){
//            ArrayList<Integer> middle = new ArrayList<>();
//
//            while(result > target/2){
//                result -= candidates[i];
//                middle.add(candidates[i]);
//                if(result == 0){
//                    list.add(middle);
//                }
//            }
//
//
//        }
//
//    }
//
//
//    public void stack(int[] candidates, List<List<Integer>> res, int i)
//}