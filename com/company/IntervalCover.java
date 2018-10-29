package com.company;

import java.util.Arrays;

public class IntervalCover {
    public static void main(String[] args) {
        int[][] inters = {{-1, 9}, {1, 10}, {0, 3}, {9, 10}, {3, 14}, {2, 9}, {10, 16}};
        int[] target = {2, 15};
        System.out.println(cover(target, inters));
    }
    public static int cover(int[] target, int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int i = 0;
        int count = 0;
        // find the interval.start <= cur && interval.end is max;
        int cur = target[0];
        while (i < intervals.length && cur < target[1]) {
            int tmp = cur;
            while (i < intervals.length && intervals[i][0] <= tmp) {
                cur = Math.max(intervals[i][1], cur);
                i++;
            }
            count++;
        }
        return cur < target[1] ? -1 : count;
    }
}
