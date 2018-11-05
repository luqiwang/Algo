package com.company;

public class DecodeStr {
    public static void main(String[] args) {
        System.out.println(decode("a---adbbbc "));
        System.out.println(decode("a-aa"));
        System.out.println(decode("a-----aaaaa"));
    }
    public static String decode(String s) {
        if (s == null || s.length() == 0) return "";
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == '-') {
                int l = i - 1;
                while (i < arr.length && arr[i] == '-') {
                    i++;
                }
                if (i == arr.length) break;
                if (arr[i] == arr[l]) {
                    for (int j = l; j <= i; j++) arr[j] = arr[i];
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            int l = i;
            while (i + 1 < arr.length && arr[i + 1] == arr[i]) i++;
            if (i > l) {
                for (int j = l; j <= i; j++) arr[j] = '+';
            }
        }
        return new String(arr);
    }
}
