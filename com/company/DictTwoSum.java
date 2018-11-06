package com.company;

import java.util.*;

public class DictTwoSum {
    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>(Arrays.asList(new int[]{1,2}, new int[]{2,1},
                new int[]{1,4}, new int[]{1,0}));
        int[][] ans = twoSum(list, 3);
        System.out.println(Arrays.toString((ans[0])));
        System.out.println(Arrays.toString((ans[1])));
    }
    public static int[][] twoSum(List<int[]> list, int k) {
        int[][] ans = new int[2][2];
        if (list.size() <= 1) return null;
        Set<List<Integer>> set = new HashSet<>();
        for (int[] cur : list) {
            List<Integer> target = Arrays.asList(k - cur[0], k - cur[1]);
            if (set.contains(target)) {
                ans[0][0] = k - cur[0];
                ans[0][1] = k - cur[1];
                ans[1] = cur;
                return ans;
            }
            set.add(Arrays.asList(cur[0], cur[1]));
        }
        return null;
    }
}
