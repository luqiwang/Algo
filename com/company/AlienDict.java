package com.company;

import java.util.Arrays;

public class AlienDict {
    public static void main(String[] args) {
        String[] arr = new String[]{"wrt", "wrf", "er", "ett", "rftt"};
        char[] dict = new char[]{'w','e','r', 't', 'f'};
        System.out.println(isValid(arr, dict));
    }
    public static boolean isValid(String[] arr, char[] dict) {
        if (arr == null || arr.length <= 1) return true;
        int[] map = new int[26];
        Arrays.fill(map, 26);
        for (int i = 0; i < dict.length; i++) {
            map[dict[i] - 'a'] = i;
        }
        for (int i = 1; i < arr.length; i++) {
            String pre = arr[i - 1];
            String cur = arr[i];
            int j = 0;
            for (; j < pre.length() && j < cur.length(); j++) {
                char c1 = pre.charAt(j);
                char c2 = cur.charAt(j);
                if (map[c1 - 'a'] > map[c2 - 'a']) {
                    return false;
                }
                if (map[c1 - 'a'] < map[c2 - 'a']) {
                    break;
                }
            }
            if (j < pre.length() && j < cur.length()) continue;
            if (pre.length() > cur.length()) return false;
        }
        return true;
    }
}
