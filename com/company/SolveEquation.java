package com.company;

import java.util.*;

public class SolveEquation {
    public static void main(String[] args) {
        String[][] strs = {{"a", "b+c"}, {"b", "c+d"}, {"c", "2"}, {"d","3"}};
        slove(strs);
    }
    public static void slove(String[][] strs) {
        Map<Character, Integer> valueMap = new HashMap<>();
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> degrees = new HashMap<>();
        for (String[] cur : strs) {
            char left = cur[0].charAt(0);
            if (Character.isDigit(cur[1].charAt(0))) {
                valueMap.put(left, Integer.valueOf(cur[1]));
            } else {
                for (char right : cur[1].toCharArray()) {
                    if (right == '+') continue;
                    if (!graph.containsKey(right)) graph.put(right, new HashSet<>());
                    graph.get(right).add(left);
                    degrees.put(left, degrees.getOrDefault(left, 0) + 1);
                }
            }
        }
        for (char c : graph.keySet()) System.out.println(c + ":" + graph.get(c).size());
        Queue<Character> queue = new LinkedList<>();
        for (char key : valueMap.keySet()) {
            queue.offer(key);
        }
        while (!queue.isEmpty()) {
            char cur = queue.poll();
            if (!graph.containsKey(cur)) continue;
            for (char next : graph.get(cur)) {
                valueMap.put(next, valueMap.getOrDefault(next, 0) + valueMap.get(cur));
                degrees.put(next, degrees.get(next) - 1);
                if (degrees.get(next) == 0) queue.offer(next);
            }
        }
        for (char c : valueMap.keySet()) {
            System.out.println(c + ": " + valueMap.get(c));
        }
    }
}
