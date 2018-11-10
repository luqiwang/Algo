package com.company;

public class BinaryPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
    }
    public static boolean isPalindrome(int num) {
        if (num % 2 == 0) return false;
        int l = 31;
        while ((num >> l) == 0) {
            l--;
        }
        int r = 0;
        while (l < r) {
            if (((num >> r) & 1) != ((num >> l) & 1)) return false;
            r++;
            l--;
        }
        return true;
    }
}
