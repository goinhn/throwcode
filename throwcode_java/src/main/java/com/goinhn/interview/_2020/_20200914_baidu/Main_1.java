package com.goinhn.interview._2020._20200914_baidu;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int l = scanner.nextInt();
        int length = scanner.nextInt();
        int[] arr = new int[length];

        for(int i = 0; i < length; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(maxFile(l, arr));

        scanner.close();
    }

    public static int maxFile(int l, int[] arr) {
        Arrays.sort(arr);
        int count = 0;
        for (int i : arr) {
            if(i <= l) {
                l -= i;
                count++;
            }else {
                break;
            }
        }

        return count;
    }


}
