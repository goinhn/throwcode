<<<<<<< Updated upstream
package com.goinhn.thorwcode.leetcode.question._1601_1700;

/**
 * 1668.最大重复子字符串
 *
 * @author goinhn
 * @date 2022/11/3
 */
public class Sol1668 {

    private static class Solution1 {
        public int maxRepeating(String sequence, String word) {
            int len = sequence.length();
            int l = word.length();
            int count = 0;
            int max = 0;
            int i = 0;
            for (int j = 0; j < len - l + 1; j++) {
                System.out.println(i);
            }
            while (i < len - l + 1) {
                if (sequence.substring(i, i + l).equals(word)) {
                    count++;
                    max = Math.max(max, count);
                    i += l;
                } else {
                    count = 0;
                    i++;
                }
            }

            return count;
        }
    }
}
=======
//package com.goinhn.thorwcode.leetcode.question._1601_1700;
//
///**
// * 1668.最大重复子字符串
// *
// * @author goinhn
// * @date 2022/11/3
// */
//public class Sol1668 {
//
//    private static class Solution1 {
//        public int maxRepeating(String sequence, String word) {
//            int len = sequence.length();
//            int l = word.length();
//            int count = 0;
//            int max = 0;
//            int i = 0;
//            for (int i = 0; i < len - l + 1; i++) {
//
//            }
//            while (i < len - l + 1) {
//                if (sequence.substring(i, i + l).equals(word)) {
//                    count++;
//                    max = Math.max(max, count);
//                    i += l;
//                } else {
//                    count = 0;
//                    i++;
//                }
//            }
//
//            return count;
//        }
//    }
//}
>>>>>>> Stashed changes
