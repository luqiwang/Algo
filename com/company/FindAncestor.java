package com.company;

import java.util.Arrays;

public class FindAncestor {
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,3};
        int[] ans = findAncestor(arr, 2);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] findAncestor(int[] arr, int D) {
        if (arr == null || arr.length == 0) return new int[0];
        if (D == 0) return arr;
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int d = D;
            int cur = i;
            while (d > 0 && cur != -1) {
                cur = arr[cur];
                d--;
            }
            ans[i] = cur;
        }
        return ans;
    }
}
