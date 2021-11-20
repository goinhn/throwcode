package com.goinhn.interview._2020._20201019_xinhuasan;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * 字符串匹配，输入某个字符串的子串，在字符串的数组中进行每个字符串的匹配，将匹配上的字符串存储在输出的list中
 * </p>
 *
 * @author goinhn
 * @date 2020-10-20T00:00:18
 */
public class Main_2 {

    public String character_auto_complete(String str) {
        String[] data = {
                "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
        };

        StringBuilder stringBuilder = new StringBuilder();
        String part = ".*" + str + ".*";
        Pattern pattern = Pattern.compile(part);
        for (int i = 0; i < data.length; i++) {
            Matcher matcher = pattern.matcher(data[i]);
            if (matcher.find()) {
                stringBuilder.append(" ").append(data[i]);
            }
        }

        return stringBuilder.length() == 0 ? "No match" : stringBuilder.substring(1);
    }

}
