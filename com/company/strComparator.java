package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class strComparator {
static class stringComprator implements Comparator<String> {
    @Override
    public int compare(String a, String b) {
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (Character.isLetter(a.charAt(i)) || Character.isLetter(b.charAt(j))) {
                if (a.charAt(i) == b.charAt(j)) {
                    i ++; j ++;
                    continue;
                }
                return a.charAt(i) - b.charAt(j);
            }

            StringBuilder sa = new StringBuilder();
            StringBuilder sb = new StringBuilder();
            while (i < a.length() && Character.isDigit(a.charAt(i)))
                sa.append(a.charAt(i ++));
            while (j < b.length() && Character.isDigit(b.charAt(j)))
                sb.append(b.charAt(j ++));
            long na = Long.parseLong(sa.toString());
            long nb = Long.parseLong(sb.toString());
            if (na == nb) continue;
            if (na < nb) return -1;
            return 1;
        }
        if (i < a.length()) return 1;
        if (j < b.length()) return -1;
        return 0;
    }
}
    public static void main(String[] args) {
        String[] arr0 = {"ab12ab", "ab12a2b"};
        String[] arr = {"input1test3", "input10test", "input2", "inputt", "input01test2"};
        Arrays.sort(arr, new stringComprator());
//        Arrays.sort(arr, new Comparator<String>() {
//            @Override
//            public int compare (String s1, String s2) {
//                if (s1.length() == 0) return -1;
//                if (s2.length() == 0) return 1;
//                int i = 0, j = 0;
//                while (i < s1.length() && j < s2.length()) {
//                    char a = s1.charAt(i);
//                    char b = s2.charAt(j);
//
//                    if (!Character.isDigit(a) && !Character.isDigit(b)) {
//                        if (a == b) {
//                            i++;
//                            j++;
//                        } else {
//                            return a < b ? -1 : 1;
//                        }
//                    } else if (!Character.isDigit(a) && Character.isDigit(b)) {
//
//                        return 1;
//                    } else if (Character.isDigit(a) && !Character.isDigit(b)) {
//                        return -1;
//                    } else {
//                        int num1 = a - '0';
//                        while (i + 1 < s1.length() && Character.isDigit(s1.charAt(i + 1))) {
//
//                            num1 = num1 * 10 + (s1.charAt(i + 1) - '0');
//                            i++;
//                        }
//                        int num2 = b - '0';
//                        while (j + 1 < s2.length() && Character.isDigit(s2.charAt(j + 1))) {
//                            num2 = num2 * 10 + (s2.charAt(j + 1) - '0');
//                            j++;
//                        }
//
//                        if (num1 == num2) {
//                            i++;
//                            j++;
//                        } else {
//                            return num1 < num2 ? -1 : 1;
//                        }
//                    }
//                }
//                if (i == s1.length()) return -1;
//                return 1;
//            }
//        });
        System.out.println(Arrays.toString(arr));
    }
}
