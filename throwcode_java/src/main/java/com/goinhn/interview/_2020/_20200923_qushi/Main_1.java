package com.goinhn.interview._2020._20200923_qushi;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main_1 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String str = scanner.nextLine();

        System.out.println(toStrLine(str));

        scanner.close();
    }

    public static String toStrLine(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = str.toCharArray();
        int index = 0;
        while(index < str.length() && Character.isDigit(chars[index])) {
            index++;
        }

        int num = "".equals(str.substring(0, index)) ? 0 : Integer.parseInt(str.substring(0, index));
        add(stringBuilder, " ", num);

        int endIndex = str.length() - 1;
        String endStr = "";
        while(endIndex >= index && !Character.isDigit(chars[index])) {
            endStr += chars[endIndex];
            endIndex--;
        }

        String lineStr = "";
        List<String> list = new LinkedList<>();
        List<Integer> listNum = new LinkedList<>();
        for(int i = index; i <= endIndex; i++) {
            if(Character.isDigit(chars[i]) && !"".equals(lineStr)) {
                list.add(lineStr);
            } else if(!Character.isDigit(chars[i])) {
                lineStr += chars[i];
            }
        }

        boolean flag = false;
        int one = 0;
        int two = 0;
        for(int i = index; i <= endIndex; i++) {
            if(!flag && Character.isDigit(chars[i])) {
                one = i;
                flag = true;
            } else if(!Character.isDigit(chars[i])) {
               two = i;
               flag = false;
               listNum.add(Integer.parseInt(str.substring(one, two)));
            }
        }

        for(int i= 0; i< list.size(); i++) {
            add(stringBuilder, list.get(i), listNum.get(i));
        }

        stringBuilder.append(endStr);

        return stringBuilder.toString();
    }

    public static void add(StringBuilder stringBuilder, String str, int n) {
        for (int i = 0; i < n; i++) {
            stringBuilder.append(str);
        }
    }

}