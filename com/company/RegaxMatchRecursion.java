package com.company;

public class RegaxMatchRecursion {
    public static void main(String[] args) {

    }
    // a+, aa
    // a*, a
    // a*, ""
    public boolean isMatch(String s, String t) {
        if (t == null || t.length() == 0) {
            return s == null || s.length() == 0;
        }
        boolean first = s.length() > 0 && s.charAt(0) == t.charAt(0);
        if (t.length() > 1 && t.charAt(1) == '*') {
            return isMatch(s, t.substring(2)) || first && isMatch(s.substring(1), t);
        }
        if (t.length() > 1 && t.charAt(1) == '+') {
            char[] arr = t.toCharArray();
            arr[1] = '*';
            return isMatch(s.substring(1), new String(arr));
        }
        return first && isMatch(s.substring(1), t.substring(1));
    }
}
