public class Solution1{
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args){
        String haystack = "kaishijieshu";
        String needle = "shi";

        System.out.println(new com.goinhn.leetcode.Solution1().strStr(haystack, needle));
    }
}