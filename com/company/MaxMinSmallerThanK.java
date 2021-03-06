package com.company;

import java.util.Arrays;

public class MaxMinSmallerThanK {
    public static void main(String[] args) {
        int[] nums = {2, 4, 5, 7};
        System.out.println(counts(nums, 10));
    }
    public static int counts(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        int count = 0;
//        subset size can be one
//        while (l <= r) {
//            if (l == r) {
//                count++;
//                l++;
//            } else {
//                if (nums[l] + nums[r] > k) {
//                    r--;
//                } else if (nums[l] + nums[r] == k) {
//                    count += Math.pow(2, r - l);
//                    l++;
//                } else {
//                    count += Math.pow(2, r - l);
//                    l++;
//                }
//            }
//        }
        while (l < r) {
            if (nums[l] + nums[r] > k) {
                r--;
            } else if (nums[l] + nums[r] <= k) {
                count += Math.pow(2, r - l) - 1;
                l++;
            }
        }
        return count;
    }
}
