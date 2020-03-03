public class Solution1 {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }

        int group = 2 * numRows - 2;
        int addTemp = s.length() % group == 0 ? 0 : group - s.length() % group;
        String sTemp = s;
        for (int i = 0; i < addTemp; i++) {
            sTemp += " ";
        }

        String result = "";
        for (int i = 0; i < group / 2 + 1; i++) {
            for (int j = 0; j < sTemp.length(); j += group) {
                if (i == 0) {
                    result += sTemp.charAt(j);
                    continue;
                }
                if (j + i == j + group - i) {
                    result += sTemp.charAt(i + j);
                    continue;
                }
                result += sTemp.charAt(j + i);
                result += sTemp.charAt(j + group - i);
            }
        }

        return result.substring(0,s.length()-addTemp);
    }

    public static void main(String[] args) {
        String str = "LEETCODEISHIRING";
        System.out.println(new Solution1().convert(str, 4));
    }
}