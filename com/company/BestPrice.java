package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//找出最大利润情况下，最合适的价格。 如接受价格范围A[8, 10] B[6, 8] C[12, 14] 此时定价应该为8因为profit为16(A,B接受此价格)最 。Interval问题， sort+优先队
public class BestPrice {
    static class Point {
        int price;
        boolean isStart;
        public Point(int price, boolean isStart) {
            this.price = price;
            this.isStart = isStart;
        }
    }
    public static void main (String[] args) {
        int[][] arr = {{8,10}, {6,8}, {12,14}};
        System.out.println(bestPrice(arr));
    }
    public static int bestPrice(int[][] intervels) {
        List<Point> points = new ArrayList<>();
        for (int[] cur : intervels) {
            points.add(new Point(cur[0], true));
            points.add(new Point(cur[1], false));
        }
        Collections.sort(points, (a, b) -> a.price != b.price ? a.price - b.price : (a.isStart ? -1 : 1));
        int maxProfit = 0;
        int maxPrice = 0;
        int count = 0;
        for (Point p : points) {
            if (p.isStart) {
                count++;
            } else {
                if (maxProfit < p.price * count) {
                    maxPrice = p.price;
                    maxProfit = p.price * count;
                }
                count--;
            }
        }
        return maxPrice;
    }

}
