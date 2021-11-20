package com.goinhn.interview._2020._20200917_jingdong;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main_1 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] line = scanner.nextLine().split(" ");
        List<String> list = isYear(line);

        for (String s : list) {
            System.out.print(s + " ");
        }
        scanner.close();
    }

    public static List<String> isYear(String[] line) {
        List<String> list = new LinkedList<>();

        String regx = "[1-3]\\d{3}";
        Pattern pattern = Pattern.compile(regx);

        for (int i = 0; i < line.length; i++) {
            Matcher matcher = pattern.matcher(line[i]);
            while (matcher.find()) {
                int start = matcher.start() - 1;
                int end = matcher.end();
                if (start > -1 && (line[i].charAt(start) >= '0' && line[i].charAt(start) <= '9')) {
                    continue;
                }
                if (end < line[i].length() && (line[i].charAt(end) >= '0' && line[i].charAt(end) <= '9')) {
                    continue;
                }

                list.add(matcher.group());
            }
        }

        return list;
    }


}