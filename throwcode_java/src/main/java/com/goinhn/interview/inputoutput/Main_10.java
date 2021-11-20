package com.goinhn.interview.inputoutput;

import java.util.Arrays;
import java.util.Scanner;

public class Main_10 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String[] array = scanner.nextLine().split(",");
            Arrays.sort(array);
            for (int i = 0, length = array.length; i < length; ++i) {
                if (i == length - 1) {
                    System.out.println(array[i]);
                    break;
                }
                System.out.print(array[i] + ",");
            }
        }
    }
}
