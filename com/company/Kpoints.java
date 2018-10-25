package com.company;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Kpoints {
    public static void main(String[] args) {
        int[][] points = {{3,0},{2,0},{1,0},{5,0},{6,0},{4,0}};
        int k = 2;
        int[][] ans = kpoints(points, 2);
        for (int[] point : ans) {
            System.out.println(Arrays.toString(point));
        }
    }
    // PQ:
//    public static int[][] kpoints(int[][] points, int k) {
//        if (points == null || points.length == 0 || k == 0) {
//            return new int[0][0];
//        }
//        int[][] ans = new int[k][2];
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> -(a[0] * a[0] + a[1] * a[1]) + (b[0] * b[0] + b[1] * b[1]));
//        for (int[] point : points) {
//            pq.offer(point);
//            if (pq.size() > k) {
//                pq.poll();
//            }
//        }
//        for (int i = k - 1; i >= 0; i--) {
//            ans[i] = pq.poll();
//        }
//        return ans;
//    }
    // QuickSelect:
    public static int[][] kpoints(int[][] points, int k) {
       findKthSmalles(points, 0, points.length - 1,  k);
       return Arrays.copyOfRange(points, 0, k);
    }
    public static void findKthSmalles(int[][] points, int start, int end, int k) {
        if (start >= end) return;
        int[] pivot = points[start];
        int l = start + 1, r = end;
        while (l <= r) {
            while (l <= r && !isFar(points[l], pivot)) l++;
            while (l <= r && isFar(points[r], pivot)) r--;
            if (l < r) {
                swap(points, l, r);
                l++;
                r--;
            }
        }
        swap(points, r, start);
        int d = r - start + 1;
        if (d == k) return;
        if (d > k) {
            findKthSmalles(points, start, r - 1, k);
        } else {
            findKthSmalles(points, r + 1, end, k - d);
        }
    }
    public static boolean isFar(int[] p1, int[] p2) {
        return (p1[0] * p1[0] + p1[1] * p1[1]) - (p2[0] * p2[0] + p2[1] * p2[1]) > 0;
    }
    public static void swap(int[][] points, int i, int j) {
        int[] tmp = points[i];
        points[i] = points[j];
        points[j] = tmp;
    }
}
