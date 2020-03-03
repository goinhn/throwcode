public class Solution1 {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }

        if(strs.length == 1){
            return strs[0];
        }

        String result = "";

        laber:
        for (int i = 0; i < strs[0].length(); i++) {
            String middle = result + strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if(i >= strs[j].length() || !middle.equals(strs[j].substring(0,i+1))){
                    break laber;
                }
            }
            result = middle;
        }

        return result;
    }

    public static void main(String[] args){
        String[] strs = new String[]{"fllower","fllow","fllight"};

        System.out.println(new Solution1().longestCommonPrefix(strs));
    }
}