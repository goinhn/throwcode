package com.goinhn.interview.inputoutput;

import java.util.Arrays;
import java.util.Scanner;

public class Main_8 {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        String[] array = new String[t];
        for (int i = 0; i < t; ++i) {
            array[i] = scanner.next();
        }
        Arrays.sort(array);
        for (int i = 0; i < t; ++i) {
            if (i == t - 1) {
                System.out.println(array[i]);
                break;
            }
            System.out.print(array[i] + " ");
        }

    }

}
