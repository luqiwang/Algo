package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class strComparator {
    public static void main(String[] args) {
        String[] arr = {"ab12ab", "ab12a2b"};
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare (String s1, String s2) {
                if (s1.length() == 0) return -1;
                if (s2.length() == 0) return 1;
                int i = 0, j = 0;
                while (i < s1.length() && j < s2.length()) {
                    char a = s1.charAt(i);
                    char b = s2.charAt(j);

                    if (!Character.isDigit(a) && !Character.isDigit(b)) {
                        if (a == b) {
                            i++;
                            j++;
                        } else {
                            return a < b ? -1 : 1;
                        }
                    } else if (!Character.isDigit(a) && Character.isDigit(b)) {

                        return 1;
                    } else if (Character.isDigit(a) && !Character.isDigit(b)) {
                        return -1;
                    } else {
                        int num1 = a - '0';
                        while (i + 1 < s1.length() && Character.isDigit(s1.charAt(i + 1))) {

                            num1 = num1 * 10 + (s1.charAt(i + 1) - '0');
                            i++;
                        }
                        int num2 = b - '0';
                        while (j + 1 < s2.length() && Character.isDigit(s2.charAt(j + 1))) {
                            num2 = num2 * 10 + (s2.charAt(j + 1) - '0');
                            j++;
                        }

                        if (num1 == num2) {
                            i++;
                            j++;
                        } else {
                            return num1 < num2 ? -1 : 1;
                        }
                    }
                }
                if (i == s1.length()) return -1;
                return 1;
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}
