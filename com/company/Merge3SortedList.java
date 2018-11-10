package com.company;

public class Merge3SortedList {
    public static void main(String[] args) {
        int[] a = { 1, 2, 41, 52, Integer.MAX_VALUE };
        int[] b = { 1, 3, 41, 52, Integer.MAX_VALUE };
        int[] c = { 1, 4, 41, 52, 67, Integer.MAX_VALUE };
        int[] ans = merge(a, b, c);
        for (int num : ans)
            System.out.print(num + " ");
        System.out.println();
    }
    public static int[] merge(int[] a, int[] b, int[] c) {
        int[] ans = new int[a.length + b.length + c.length];
        int index = 0;
        int i = 0, j = 0, k = 0;
        while (i < a.length || j < b.length || k < c.length) {
            long cura = i >= a.length ? Long.MAX_VALUE : a[i];
            long curb = j >= b.length ? Long.MAX_VALUE : b[j];
            long curc = k >= c.length ? Long.MAX_VALUE : c[k];
            long min = Math.min(Math.min(cura, curb), curc);
            ans[index++] = (int)min;
            if (min == cura) i++;
            else if (min == curb) j++;
            else if (min == curc) k++;
        }
        return ans;
    }
}
