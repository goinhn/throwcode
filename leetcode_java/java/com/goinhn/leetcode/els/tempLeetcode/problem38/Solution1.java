public class Solution1 {
    //只包含1,2的解决
    public String countAndSay(int n) {
        if (n <= 1) {
            return "1";
        } else {
            String middle = countAndSay(n - 1);
            String result = "";

            while (middle.length() != 0) {
                if (middle.charAt(0) == '2') {
                    result += "12";
                    middle = middle.substring(1, middle.length());

                } else if (middle.length() > 1) {
                    if (middle.charAt(0) == '1' && middle.charAt(1) != '1') {
                        result += "11";
                        middle = middle.substring(1, middle.length());

                    } else if (middle.charAt(0) == '1' && middle.charAt(1) == '1') {
                        result += "21";
                        middle = middle.substring(2, middle.length());
                    }

                } else if (middle.length() == 1) {
                    result += "11";
                    middle = middle.substring(1, middle.length());
                }
            }

            return result;
        }

    }

    public static void main(String[] args) {
        System.out.println(new com.goinhn.leetcode.Solution1().countAndSay(3));
    }
}