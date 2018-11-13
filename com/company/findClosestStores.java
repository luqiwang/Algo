package com.company;

import java.util.Arrays;

public class findClosestStores {
    public static void main(String[] args) {
        int[] stores = {1,5,20,11,16};
        int[] houses = {5, 10, 17};
        int[] ans = findStores(stores, houses);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] findStores(int[] stores, int[] houses) {
        if (houses == null || houses.length == 0) return new int[0];
        Arrays.sort(stores);
        int[] ans = new int[houses.length];
        for (int i = 0; i < houses.length; i++) {
            ans[i] = findClosest(stores, houses[i]);
        }
        return ans;
    }
    public static int findClosest(int[] stores, int house) {
        if (stores == null || stores.length == 0) return -1;
        int l = 0, r = stores.length - 1;
        while (l + 1 < r) {
            int mid = (r - l) / 2 + l;
            if (stores[mid] <= house) {
                l = mid;
            } else {
                r = mid;
            }
        }
        if (Math.abs(stores[l] - house) <= Math.abs(stores[r] - house)) {
            return stores[l];
        } else {
            return stores[r];
        }
    }
}
