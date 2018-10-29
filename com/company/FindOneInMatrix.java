package com.company;

public class FindOneInMatrix {
    public static void main(String[] args) {
        int[][] m = {
            {0,0,0,0,0,1},
            {0,0,0,1,1,1},
            {0,0,1,1,1,1}
        };
        System.out.println(find(m)[0] + " " + find(m)[1]);
    }
    public static int[] find(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n - 1;
        while (matrix[i][j] == 0) {
            i++;
        }
        if (i >= m) return new int[0];
        int col = j;
        int row = i;
        while (i < m) {
            while (j - 1 >= 0 && matrix[i][j - 1] == 1) {
                j--;
                if (j < col) {
                    row = i;
                    col = j;
                }
            }
            i++;
        }
        return new int[]{row, col};
    }
}
