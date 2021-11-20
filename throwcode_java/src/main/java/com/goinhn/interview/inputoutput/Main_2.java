package com.goinhn.interview.inputoutput;

import java.util.Scanner;

public class Main_2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int lineNumber = s.nextInt();
        for (int i = 0; i < lineNumber; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            System.out.println(a + b);
        }
    }
}
