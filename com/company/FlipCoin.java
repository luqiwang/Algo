package com.company;

import java.util.Random;

public class FlipCoin {
    static Random random = new Random();
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            int cur = getExpect();
            sum += cur;
        }
        System.out.println(sum / 1000);
    }
    public static int getExpect() {
        int count = 0;
        int times = 0;
        while (count < 3) {
            times++;
            if (random.nextBoolean()) {
                count++;
            } else {
                count = 0;
            }
        }
        return times;
    }
}
