package com.company;

import java.util.ArrayList;
import java.util.List;

public class MatrixPath {
    public static void main(String[] args) {
        char[][] matrix = {{'a', 'b','c'}, {'d', 'e', 'f'}};
        List<String> ans = new ArrayList<>();
        dfs(ans, matrix, 0, 0, new StringBuilder());
        for (String s : ans) {
            System.out.println(s);
        }
    }
    public static void dfs(List<String> ans, char[][] matrix, int row, int col, StringBuilder sb) {
        int m = matrix.length;
        int n = matrix[0].length;
        int len = sb.length();
        sb.append(matrix[row][col]);
        if (row == m - 1 && col == n - 1) {
            ans.add(sb.toString());
        } else {
            sb.append("->");
            if (row + 1 < m) {
                dfs(ans, matrix, row + 1, col, sb);
            }
            if (col + 1 < n) {
                dfs(ans, matrix, row, col + 1, sb);
            }
        }
        sb.setLength(len);
    }
}
