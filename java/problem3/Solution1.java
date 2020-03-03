import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int nowLength = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            nowLength = 0;
            map.clear();
            map.put(s.charAt(i), i);
            nowLength++;
            for (int j = i + 1; j < s.length(); j++) {
                if (map.containsKey(s.charAt(j))) {
                    if (j - i > nowLength) {
                        nowLength = j - i;
                    }
                    break;
                }
                map.put(s.charAt(j), j);
                nowLength++;
            }
            if(nowLength > maxLength){
                maxLength = nowLength;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcabb";
        System.out.println(new Solution1().lengthOfLongestSubstring(s));
    }
}