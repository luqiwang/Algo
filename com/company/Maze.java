package com.company;

import java.util.*;

public class Maze {
    public static void main(String[] args) {
        char[][] board = {
                {'a', 'A', 'b'},
                {'1', 'B', '2'},
                {'2', '1', '1'}
        };
        System.out.println(shortestPath(board));
    }
    static int[] X = {1, -1, 0, 0};
    static int[] Y = {0, 0, -1, 1};
    public static int shortestPath(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return 0;
        int m = board.length;
        int n = board[0].length;
        Queue<List<Integer>> queue = new LinkedList<>();
        // {row, col, keys};
        queue.offer(Arrays.asList(0, 0, 0));
        Set<List<Integer>> set = new HashSet<>();
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0;i < size; i++) {
                List<Integer> cur = queue.poll();
                set.add(cur);
                int row = cur.get(0);
                int col = cur.get(1);
                int keys = cur.get(2);
                char ch = board[row][col];
                if (ch >= 'a' && ch <= 'z') {
                    keys = (keys | (1 << ch -'a'));
                }
                if (row == m - 1 && col == n - 1) return step;
                for (int d = 0; d < 4; d++) {
                    int nextRow = row + X[d];
                    int nextCol = col + Y[d];
                    if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || board[nextRow][nextCol] == '2') continue;
                    char nc = board[nextRow][nextCol];
                    if (nc >= 'A' && nc <= 'Z') {
                        if ((keys & (1 << (nc - 'A'))) > 0)  {
                            List<Integer> nextList = Arrays.asList(nextRow, nextCol, keys);
                            if (set.contains(nextList)) {
                                continue;
                            }
                            queue.offer(nextList);
                        }
                    } else {
                        List<Integer> nextList = Arrays.asList(nextRow, nextCol, keys);
                        if (set.contains(nextList)) continue;
                        queue.offer(nextList);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
