package com.company;

// You can replace k 0 to 1, find the longest subarray
public class LongestOnes {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,0,0,1,1,1,1};
        System.out.println(longestOnes(nums, 2));
    }
    public static int longestOnes(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int l = 0, r = 0;
        int count = 0;
        int ans = 0;
        while (r < nums.length) {
            if (nums[r] == 1) {
                count++;
            }
            while (r - l + 1 - count > k) {
                if (nums[l] == 1) {
                    count--;
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}
