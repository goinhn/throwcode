//import java.util.ArrayList;
//import java.util.List;
//
//public class Solution1 {
//    private List<String> list = new ArrayList<String>();
//
//    // count代表左括号未消去的值
//    public List<String> generateParenthesis(int n) {
//        if (n == 0) {
//            return list;
//        } else {
//            add(n, "(", 1);
//            return list;
//        }
//    }
//
//    public void add(int n, String s, int count) {
//        if (s.length() == n * 2 - 1) {
//            if (count == 1) {
//                list.add(s + ")");
//                return;
//            }
//            return;
//        }
//
//        // 设置两种情况
//        for (int i = 0; i < 2; i++) {
//            if (count > 0) {
//                if (i == 0) {
//                    add(n, s + "(", count + 1);
//                } else {
//                    add(n, s + ")", count - 1);
//                }
//            } else if (count == 0) {
//                if (i == 0) {
//                    add(n, s + "(", count + 1);
//                } else {
//                    continue;
//                }
//            }
//        }
//    }
//
//
//
//}