package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NestedList {
    static class NestedInteger {
        private boolean isInt;
        private int val;
        private List<NestedInteger> list;
        public NestedInteger(int val) {
            this.val = val;
            this.isInt = true;
        }
        public NestedInteger(List<NestedInteger> list) {
            this.list = list;
            isInt = false;
        }
        public boolean isInteger() {
            return isInt;
        }
        public int getInteger() {
            return val;
        }
        public List<NestedInteger> getList() {
            return list;
        }
    }
    public static void main(String[] args) {
        NestedInteger n1 = new NestedInteger(1);
        NestedInteger n2 = new NestedInteger(1);
        List<NestedInteger> list = new ArrayList<>();
        list.add(n1);
        list.add(n2);
        NestedInteger n3 = new NestedInteger(2);
        NestedInteger n4 = new NestedInteger(list);
        List<NestedInteger> nestedList = new ArrayList<>(Arrays.asList(n4, n3, n4));
        System.out.println(getSum(nestedList));
    }
    public static int getSum(List<NestedInteger> nestedList) {
        return getSum(nestedList, 1);
    }
    public static int getSum(List<NestedInteger> nestedList, int level) {
        int sum = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                sum += ni.getInteger() * level;
            } else {
                sum += getSum(ni.getList(), level + 1);
            }
        }
        return sum;
    }
}

