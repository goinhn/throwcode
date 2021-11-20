package com.goinhn.interview._2020._20201010_hengsheng;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * 恒生电子
 *
 * 两个从小到大排序的数组，
 * </p>
 *
 * @author goinhn
 * @date 2020-10-10T23:41:18
 */
public class Main_1 {

    public List<Integer> getPub(int[] a, int[] b) {
        int indexA = 0;
        int indexB = 0;
        List<Integer> list = new LinkedList<>();
        while(indexA < a.length && indexB < b.length) {
            if(a[indexA] < b[indexB]) {
                indexA++;
            } else if(a[indexA] > b[indexB]) {
                indexB++;
            } else {
                list.add(a[indexA]);
                indexA++;
                indexB++;
            }
        }

        return list;
    }

}
