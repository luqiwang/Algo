package com.company;

import java.util.Arrays;
import java.util.Random;

public class FindRandomK {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,2}, {3,4,5}, {6,7,8}};
        System.out.println(Arrays.toString(findRandomK(matrix, 3)));
    }
    // 每抽一个把它放最后面，减少随机范围
    public static int[] findRandomK(int[][] matrix, int k) {
        Random random = new Random();
        int m = matrix.length;
        int n = matrix[0].length;
        int[] ans = new int[k];
        int total = m * n;
        for (int i = 0; i < k; i++) {
            int rd = random.nextInt(total);
            int row = rd / n;
            int col = rd % n;
            ans[i] = matrix[row][col];
            total--;
            matrix[row][col] = matrix[total / n][total % n];
        }
        return ans;
    }
    //Reservoir Sampling
    //n里找k个随机数
    public int[] findK(int[] nums, int k) {
        int[] ans = new int[k];
        int n = nums.length;
        Random random = new Random();
        for (int i = 0; i < k; i++) {
            ans[i] = nums[i];
        }
        for (int i = k; i < n; i++) {
            int cur = random.nextInt(i);
            if (cur < k) {
                ans[cur] = nums[i];
            }
        }
        return ans;
    }
    // n 里找 k 个最大的数的index;

}


