package com.goinhn.interview._2020._20201011_58tongcheng;

import java.util.ArrayList;

/**
 * <p>
 * 对二叉树进行前中后序的遍历
 * </p>
 *
 * @author goinhn
 * @date 2020-10-11T20:38:51
 */
public class Main_3 {

    private ArrayList<Integer> pre;
    private ArrayList<Integer> mid;
    private ArrayList<Integer> aft;

    public ArrayList<ArrayList<Integer>> binaryTreeScan(int[] input) {
        pre = new ArrayList<>();
        mid = new ArrayList<>();
        aft = new ArrayList<>();

        getTree(input, 0);

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(pre);
        list.add(mid);
        list.add(aft);

        return list;
    }

    public void getTree(int[] input, int index) {
        if (index > -1 && index < input.length && input[index] != -1) {
            pre.add(input[index]);
            getTree(input, 2 * index + 1);
            mid.add(input[index]);
            getTree(input, 2 * index + 2);
            aft.add(input[index]);
        }
    }


    public static void main(String[] args) {
        int[] input = {1, 7, 2, 6, -1, 4, 8};

        ArrayList<ArrayList<Integer>> list = new Main_3().binaryTreeScan(input);

        System.out.println(list);
    }


}
