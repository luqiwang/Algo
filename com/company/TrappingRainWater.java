package com.company;

public class TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(trappingWater2(new int[]{3, 1, -1, 2,1,2}));
//        System.out.println(trappingWater1(new int[]{3, 1, 0, 2,1,2}));
    }
    public static int trappingWater2(int[] heights) {
        if (heights == null || heights.length <= 1) return 0;
        int l = 0, r = heights.length - 1;
        int ans = 0;
        while (l < r) {

            if (heights[l] <= heights[r]) {
                boolean leak = false;
                int tmp = ans;
                int h = heights[l++];
                while (l < r && heights[l] < h) {
                    if (heights[l] == -1) {
                        leak = true;
                        ans = tmp;
                    }
                    if (!leak) ans += h - heights[l];
                    l++;
                }

            } else {
                int h = heights[r--];
                int tmp = ans;
                boolean leak = false;
                while (l < r && heights[r] < h) {
                    if (heights[r] == -1) {
                        leak = true;
                        ans = tmp;
                    }
                    if (!leak) ans += h - heights[r];
                    r--;
                }
            }
        }
        return ans;
    }
    public static int trappingWater1(int[] heights) {
        if (heights == null || heights.length <= 1) return 0;
        int l = 0, r = heights.length - 1;
        int ans = 0;
        while (l < r) {
            if (heights[l] <= heights[r]) {
                int h = heights[l++];
                while (l < r && heights[l] <= h) {
                    ans += h - heights[l];
                    l++;
                }
            } else {
                int h = heights[r--];
                while (l < r && heights[r] <= h) {
                    ans += h - heights[r];
                    r--;
                }
            }
        }
        return ans;
    }
}
