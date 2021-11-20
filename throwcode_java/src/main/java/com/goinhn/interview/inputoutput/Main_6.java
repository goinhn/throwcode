package com.goinhn.interview.inputoutput;

import java.util.Scanner;

public class Main_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();
            int sum = 0;
            for (int j = 0; j < n; j++) {
                int a = sc.nextInt();
                sum = sum + a;
            }
            System.out.println(sum);
        }
    }
}
