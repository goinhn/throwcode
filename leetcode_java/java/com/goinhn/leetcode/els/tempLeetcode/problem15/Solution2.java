import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 3) {
            return list;
        }

        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                break;
            }
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            int begin = i + 1;
            int end = len - 1;
            while (begin < end) {
                int sum = nums[i] + nums[begin] + nums[end];
                
                if (sum > 0) {
                    end--;
                } else if (sum < 0) {
                    begin++;
                } else {
                    list.add(Arrays.asList(nums[i], nums[begin], nums[end]));
                    while (begin < end ) {
                        begin++;
                        if(nums[begin] != nums[begin-1]){
                            break;
                        }
                    }
                    while (begin < end) {
                        end--;
                        if(nums[end] != nums[end+1]){
                            break;
                        }
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,2,-1,1,4,5,0,6,8,-10};

        List<List<Integer>> list = new com.goinhn.leetcode.Solution2().threeSum(nums);

        Iterator iterator = list.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        
    }
}