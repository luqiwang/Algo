package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] tasks = new int[]{1,2,1,2,3,2,4};
        int n = 3;
        System.out.println(taskSchdule(tasks, n));
    }
    public static int taskSchdule(int[] tasks, int n) {
        // schedule, -1 means idel
        List<Integer> ans = new ArrayList<>();
        int time = 0;
        // key taskId, value is last time it excute
        Map<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            time++;
            if (!map.containsKey(task)) {
                map.put(task, time);
                ans.add(task);
            } else {
                while (time - map.get(task) <= n) {
                    time++;
                    ans.add(-1);
                }
                ans.add(task);
                map.put(task, time);
            }
        }
        int[] arr = ans.stream().mapToInt(i->i).toArray();
        System.out.println(Arrays.toString(arr));
        return time;
    }
}