public class Solution1{
    public int myAtoi(String str) {
        str = str.trim();
        if (str == null || str.length() == 0)
            return 0;

        int sign = 1;
        int start = 0;
        int res = 0;
        if (str.charAt(0) == '+') {
            sign = 1;
            start++;
        } else if (str.charAt(0) == '-') {
            sign = -1;
            start++;
        }

        for (int i = start; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return (int) res * sign;
            }
            int middle = str.charAt(i) - '0';
            
            if (sign*res > Integer.MAX_VALUE/10 || (sign*res == Integer.MAX_VALUE/10 && middle > 7))
                return Integer.MAX_VALUE;
            if (sign*res < Integer.MIN_VALUE/10 || (sign*res == Integer.MIN_VALUE/10 && middle > 8))
                return Integer.MIN_VALUE;

            res = res * 10 + middle;
        }
        return (int) res * sign;
    }

    public static void main(String[] args){
        String str = "-2147483649";

        System.out.println(new Solution1().myAtoi(str));
    }
}