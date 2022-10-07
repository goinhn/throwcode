package com.goinhn.thorwcode.leetcode.question._1601_1700;

import java.util.ArrayList;
import java.util.List;

/**
 * 1694.重新格式化电话号码
 *
 * @author goinhn
 * @date 2022/10/1
 */
public class Sol1694 {

    /**
     * time:O(n)
     * space:O(n)
     */
    public String reformatNumber(String number) {
        List<Character> numList = new ArrayList<>();
        for (char ch : number.toCharArray()) {
            if (ch == ' ' || ch == '-') {
                continue;
            }
            numList.add(ch);
        }

        int limit = numList.size() % 3;
        if (limit == 1) {
            limit = 4;
        }

        if (limit == 0) {
            limit = 3;
        }

        StringBuilder str = new StringBuilder();
        int preLimit = numList.size() - limit;
        for (int i = 0; i < preLimit; i++) {
            str.append(numList.get(i));
            if ((i + 1) % 3 == 0) {
                str.append('-');
            }
        }

        if (limit == 3) {
            str.append(numList.get(preLimit))
                    .append(numList.get(preLimit + 1))
                    .append(numList.get(preLimit + 2));
        } else if (limit == 2) {
            str.append(numList.get(preLimit))
                    .append(numList.get(preLimit + 1));
        } else if (limit == 4) {
            str.append(numList.get(preLimit))
                    .append(numList.get(preLimit + 1))
                    .append('-')
                    .append(numList.get(preLimit + 2))
                    .append(numList.get(preLimit + 3));
        }

        return str.toString();
    }

}
