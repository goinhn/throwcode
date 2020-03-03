import java.util.*;

public class Solution1 {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for(int i = 0;i<s.length();i++){
            if(map.containsValue(s.charAt(i))){
                stack.push(s.charAt(i));
            }else if(!stack.empty() && i != 0 && map.get(s.charAt(i)) == stack.peek()){
                stack.pop();
            }else{
                return false;
            }
        }

        if(stack.empty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        String str = "}";

        System.out.println(new Solution1().isValid(str));
    }
}