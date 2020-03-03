public class Solution1 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int xTemp = x;
        int sum = 0;
        while (xTemp > 0) {
            sum = sum * 10 + xTemp % 10;
            xTemp /= 10;
        }

        if (sum == x) {
            return true;
        }

        return false;
    }

    public static void main(String[] args){
        int number = 121;
        System.out.println(new Solution1().isPalindrome(number));
    }
}