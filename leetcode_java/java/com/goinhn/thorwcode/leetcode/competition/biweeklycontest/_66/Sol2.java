package com.goinhn.thorwcode.leetcode.competition.biweeklycontest._66;

/**
 * @author goinhn
 * @date 2021/11/27
 */
public class Sol2 {

    private static class Solution1 {
        public int minimumBuckets(String street) {
            char[] streetChr = street.toCharArray();
            int count = 0;
            for (int i = 0; i < streetChr.length; i++) {
                if (i > 0 && i < streetChr.length - 1) {
                    if (streetChr[i - 1] == 'H' && streetChr[i] == 'H' && streetChr[i + 1] == 'H') {
                        return -1;
                    } else if (streetChr[i - 1] == 'H' && streetChr[i] == '.' && streetChr[i + 1] == 'H') {
                        streetChr[i - 1] = 'a';
                        streetChr[i + 1] = 'a';
                        count++;
                    }
                }
            }

            for (int i = 0; i < streetChr.length; i++) {
                if (streetChr[i] == 'H') {
                    if (i - 1 >= 0 && streetChr[i - 1] == '.') {
                        streetChr[i] = 'a';
                        count++;
                    } else if (i + 1 < streetChr.length && streetChr[i + 1] == '.') {
                        streetChr[i] = 'a';
                        count++;
                    }
                }
            }

            for (int i = 0; i < streetChr.length; i++) {
                if (streetChr[i] == 'H') {
                    return -1;
                }
            }

            return count;
        }

        public static void main(String[] args) {
            System.out.println(new Solution1().minimumBuckets(".HH.HH.HH.HH..H"));
        }
    }
}
