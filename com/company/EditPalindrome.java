package com.company;

import java.util.Arrays;

public class EditPalindrome {
    public static void main(String[] args) {
        System.out.println(editdis("abc"));
    }
    public static int editdis(String s) {
        if (s == null || s.length() <= 1) return 0;
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, n);
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (i + 1 == j) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    if (i + 1 == j) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i + 1][j - 1], dp[i + 1][j]), dp[i][j - 1]) + 1;
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}
