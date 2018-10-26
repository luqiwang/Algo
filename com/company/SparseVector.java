package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SparseVector {
    public static void main(String[] args) {
        int[] a = {0,2,0,2,0,0,3,0,0,4};
        int[] b = {0,0,0,0,5,0,2,0,0,8};
        int[][] c = {{1,2}, {3,2}, {6,3}, {9, 4}};
        int[][] d = {{4,5}, {6,2}, {9, 8}};
//        System.out.println(vectorProduct1(a,b));
//        System.out.println(vectorProduct2(c,d));
        System.out.println(vectorProduct3(c,d));
    }
    // 1 HashMap
    public static int vectorProduct1(int[] a, int[] b) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) map1.put(i, a[i]);
            if (b[i] != 0) map2.put(i, b[i]);
        }
        int ans = 0;
        for (int key : map1.keySet()) {
            if (!map2.containsKey(key)) continue;
            ans += map1.get(key) * map2.get(key);
        }
        return ans;
    }
    // int[][]表示向量, BinarySearch
    public static int vectorProduct2(int[][] a, int[][] b) {
        if (a.length > b.length) {
            return vectorProduct2(b, a);
        }
        int ans = 0;
        for (int[] tuple : a) {
            int index = tuple[0];
            int val = tuple[1];
            int l = 0, r = b.length - 1;
            while (l + 1 < r) {
                int mid = (r - l) / 2 + l;
                if (b[mid][0] <= index) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
            if (b[l][0] == index) {
                ans += val * b[l][1];
            } else if (b[r][0] == index) {
                ans += val * b[r][1];
            }
        }
        return ans;
    }
    // Two pointer
    public static int vectorProduct3(int[][] a, int[][] b) {
        int i = 0;
        int j = 0;
        int ans = 0;
        while (i < a.length && j < b.length) {
            if (a[i][0] > b[j][0]) {
                j++;
            } else if (a[i][0] < b[j][0]) {
                i++;
            } else {
                ans += a[i][1] * b[j][1];
                i++;
                j++;
            }
        }
        return ans;
    }
}
