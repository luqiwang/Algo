package com.company;

import java.util.*;

public class taskSchdule {
    public static void main(String[] args) {
        int[] tasks = new int[]{1,2,1,2,3,2,4};
        int n = 3;
        System.out.println(taskSchdule1(tasks, n));
    }
    // in original order
    public static int taskSchdule1(int[] tasks, int n) {
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
    // Output one of the final task schedule without order with cool time
    public static List<Character> taskSchdule12(char[] tasks, int n) {
        List<Character> ans = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }
        int tasksCount = tasks.length;
        int time = 0;
        while (tasksCount > 0) {
            List<Map.Entry<Character, Integer>> tmp = new ArrayList<>();
            int k = n + 1;
            while (k > 0 && tasksCount > 0) {
                if (pq.isEmpty()) {
                    time++;
                    ans.add('*');
                    k--;
                } else {
                    Map.Entry<Character, Integer> cur = pq.poll();
                    if (cur.getValue() > 1) {
                        cur.setValue(cur.getValue() - 1);
                        tmp.add(cur);
                    }
                    ans.add(cur.getKey());
                    tasksCount--;
                    k--;
                    time++;
                }
            }
            pq.addAll(tmp);
        }
        Character[] arr = ans.toArray(new Character[0]);
        System.out.println(Arrays.toString(arr));
        // return time;
        return ans;
    }
}
