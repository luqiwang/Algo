package com.company;

public class Salary {
    public static void main(String[] args) {
        Double[][] taxes = {{1000.0,0.1},{2000.0,0.2},{null, 0.4}};
        System.out.println(compute(3000, taxes));
    }
    public static double compute(int num, Double[][] taxes) {
        int ans = 0;
        for (int i = 0; i < taxes.length && num > 0; i++) {
            if (i == taxes.length - 1) {
                ans += taxes[i][1] * num;
                num = 0;
            } else {
                ans += taxes[i][1] * Math.min(num, taxes[i][0]);
                num -= taxes[i][0];
            }
        }
        return ans;
    }
}
