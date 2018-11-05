package com.company;

public class ExpressionAddOperator {
    public static void main(String[] args) {
        numberOfWays("00", 0);
    }
    public static int numberOfWays(String num, int target) {
        if (num == null || num.length() == 0) return 0;
        int ans = dfs(num, target, 0, 0);
        System.out.println(ans);
        return ans;
    }
    public static int dfs(String num, int target, int start, int sum) {
        if (start == num.length()) {
            if (sum == target) return 1;
            return 0;
        }
        int ans = 0;
        for (int i = start; i < num.length(); i++) {
            if (num.charAt(start) == '0' && i > start) break;
            int cur = Integer.valueOf(num.substring(start, i + 1));
            ans += dfs(num, target, i + 1, sum + cur);
            if (start != 0) ans += dfs(num, target, i + 1, sum - cur);
        }
        return ans;
    }
}
