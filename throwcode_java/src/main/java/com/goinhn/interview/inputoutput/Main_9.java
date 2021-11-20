package com.goinhn.interview.inputoutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main_9 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String[] str = in.nextLine().split(" ");
            int len = str.length;
            ArrayList<String> list = new ArrayList<String>(Arrays.asList(str));
            Collections.sort(list);
            for (int i = 0; i < len; i++){
                if (i != len - 1){
                    System.out.print(list.get(i) + " ");
                }else{
                    System.out.print(list.get(i));
                }
            }
            System.out.println();
        }
    }
}
