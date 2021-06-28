import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public int romanToInt(String s) {
        Map<Character, Integer> romaNumber = new HashMap<>();
        romaNumber.put('I', 1);
        romaNumber.put('V', 5);
        romaNumber.put('X', 10);
        romaNumber.put('L', 50);
        romaNumber.put('C', 100);
        romaNumber.put('D', 500);
        romaNumber.put('M', 1000);
        int number = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (romaNumber.get(s.charAt(i)) >= romaNumber.get(s.charAt(i + 1))) {
                number += romaNumber.get(s.charAt(i));
            } else {
                number -= romaNumber.get(s.charAt(i));
            }
        }
        number += romaNumber.get(s.charAt(s.length()-1));

        return number;
    }

    public static void main(String[] args){
        String roma = "LVIII";
        System.out.println(new com.goinhn.leetcode.Solution1().romanToInt(roma));

    
    }
}