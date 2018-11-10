package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvParser {
    public static void main (String[] args) {
        String[] arr = {"\"a;bc", "cde"};
        String[] arr1 = {"a;b;c", "cde"};
        String[] arr3 = {"a\"bc", "cde"};
        String s = encode(arr3);
        System.out.println(s);
        String[] arr2 = decode(s);
        System.out.println(Arrays.toString(arr2));
    }
    public static String encode(String[] arr) {
        if (arr == null || arr.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (String cur : arr) {
            if (cur.indexOf(";") >= 0) {
                sb.append("\"");
                for (char c : cur.toCharArray()) {
                    if (c == '\"') {
                        sb.append("\"\"");
                    } else {
                        sb.append(c);
                    }
                }
                sb.append("\"");
            } else {
                for (char c : cur.toCharArray()) {
                    if (c == '\"') {
                        sb.append("\"\"");
                    } else {
                        sb.append(c);
                    }
                }
            }
            sb.append(';');
        }
        return sb.substring(0, sb.length() - 1);
    }
    // decode 的时候,两种情况讨论：
    // 如果开始的字符不是 " : 那里面的""一定连续出现，append一个
    //如果开始的字符是" : 结尾一定是个"。
    // 记得跳过分割用的;
    public static String[] decode(String s) {
        List<String> ans = new ArrayList<>();
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            left = i;
            if (s.charAt(i) != '\"') {
                StringBuilder sb = new StringBuilder();
                while (i < s.length() && s.charAt(i) != ';') {
                    if (s.charAt(i) == '"') {
                        i++;
                    }
                    sb.append(s.charAt(i++));
                }
                ans.add(sb.toString());
            } else {
                i++;
                StringBuilder sb = new StringBuilder();
                while (!(s.charAt(i) == '"' && (i + 1 == s.length() || s.charAt(i + 1) != '"'))) {
                    if (s.charAt(i) == '"') {
                        sb.append('"');
                        i++;
                    } else {
                        sb.append(s.charAt(i));
                    }
                    i++;
                }
                System.out.println(i);
                ans.add(sb.toString());
                i++;
            }
        }
        return ans.toArray(new String[0]);
    }
}
