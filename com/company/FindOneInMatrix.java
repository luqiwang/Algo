package com.company;

public class FindOneInMatrix {
    public static void main(String[] args) {
        int[][] m = {
            {0,0,0,0,0,1},
            {0,0,0,1,1,1},
            {0,0,1,1,1,1}
        };
        System.out.println(find(m)[0] + " " + find(m)[1]);
        System.out.println(find2(m)[0] + " " + find2(m)[1]);
    }
    public static int[] find(int[][] matrix) {
//        int m = matrix.length;
//        int n = matrix[0].length;
//        int i = 0;
//        int j = n - 1;
//        while (matrix[i][j] == 0) {
//            i++;
//        }
//        if (i >= m) return new int[0];
//        int col = j;
//        int row = i;
//        while (i < m) {
//            while (j - 1 >= 0 && matrix[i][j - 1] == 1) {
//                j--;
//                if (j < col) {
//                    row = i;
//                    col = j;
//                }
//            }
//            i++;
//        }
//        return new int[]{row, col};
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < m && matrix[i][j] != 1) {
            i++;
        }
        int row = i, col = j;
        if (i == m) return new int[0];
        while (i < m) {
            while (j - 1 >= 0 && matrix[i][j - 1] == 1) {
                j--;
            }
            if (col > j) {
                col = j;
                row = i;
            }
            i++;
        }
        return new int[]{row, col};
    }
    public static int[] find2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = m, col = n;
        for (int i = 0; i < m; i++) {
            int first = search(matrix[i]);
            if (first == -1) continue;
            if (first < col) {
                row = i;
                col = first;
            }
        }
        if (col == n) return new int[0];
        return new int[]{row, col};
    }
    public static int search(int[] row) {
        int l = 0, r = row.length - 1;
        while (l + 1 < r) {
            int mid = (r - l) / 2 + l;
            if (row[mid] == 1) {
                r = mid;
            } else {
                l = mid;
            }
        }
        if (row[l] == 1) return l;
        if (row[r] == 1) return r;
        return -1;
    }
}
