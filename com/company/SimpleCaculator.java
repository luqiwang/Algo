package com.company;

public class SimpleCaculator {
    public static void main(String[] args) {
        System.out.println(compute("21 + 3 * 4 * 5"));
    }
    public static int compute(String s) {
        if (s == null || s.length() == 0) return 0;
        int sum = 0;
        int pre = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c ==  ' ') continue;
            if (Character.isDigit(c)) {
                int num = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = 10 * num + (s.charAt(i + 1) - '0');
                    i++;
                }
                if (sign == '+') {
                    sum += num;
                    pre = num;
                } else {
                    sum = sum - pre + pre * num;
                    pre = pre * num;
                }
            } else {
                sign = c;
            }
        }
        return sum;
    }
}
