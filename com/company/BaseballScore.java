package com.company;

import java.util.Arrays;

public class BaseballScore {
    public static void main(String[] args) {
        System.out.println(numerOfWasy(7));
    }
    public static int numerOfWasy(int point) {
        int[][] dp = new int[point + 1][2];
        dp[0][0] = 1;
        dp[0][1] =0;
        for (int i = 1; i <= point; i++) {
            if (i - 2 >= 0) dp[i][0] += dp[i - 2][0];
            if (i - 3 >= 0) dp[i][0] += dp[i - 3][0];
            if (i - 6 >= 0) dp[i][0] += dp[i - 6][0];
            if (i - 6 >= 0) {
                dp[i][1] = dp[i - 6][0] + dp[i - 2][1] + dp[i - 3][1] + dp[i - 1][1] + dp[i - 6][1];
            }
        }
        System.out.println(dp[point][0]);
        System.out.println(dp[point][1]);
        return dp[point][0] + dp[point][1];
    }
}
