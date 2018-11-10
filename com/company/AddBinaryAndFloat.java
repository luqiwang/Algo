package com.company;

public class AddBinaryAndFloat {
    public static  void main (String[] args) {
//        System.out.println(add("ABC", "BF2D", 16));
//        System.out.println(add("99", "1", 10));
//        System.out.println(add("1", "10", 2));
        System.out.println(addFloat("9.2", "2"));
    }
    public static String add2(String a, String b) {
        return "";
    }

    public static String add(String a, String b, int k) {
        if (a == null || a.length() == 0) return b;
        if (b == null || b.length() == 0) return a;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            if (a.charAt(i) == '.') {
                i--;
                j--;
                sb.append('.');
                continue;
            }
            int num1 = i >=0 ? Character.getNumericValue(a.charAt(i)) : 0;
            int num2 = j >=0 ? Character.getNumericValue(b.charAt(j)) : 0;
            int sum = num1 + num2 + carry;
            sb.append(Character.forDigit((sum % k), k));
            carry = sum / k;
            i--;
            j--;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
    public static String addFloat(String num1, String num2) {
        String[] arr1 = num1.split("\\.");
        String[] arr2 = num2.split("\\.");
        // add int part
        String beforePoint = addInt(arr1[0], arr2[0]);
        // add point part
        String point1 = arr1.length == 1 ? "0" : arr1[1];
        String point2 = arr2.length == 1 ? "0" : arr2[1];
        while (point1.length() < point2.length()) point1 += "0";
        while (point2.length() < point1.length()) point2 += "0";
        String afterPoint = addInt(point1, point2);
        if (afterPoint.length() > point1.length()) {
            beforePoint = addInt(beforePoint, afterPoint.substring(0, 1));
            return beforePoint + "." + afterPoint.substring(1);
        } else {
            return beforePoint + "." + afterPoint;
        }
    }
    public static String addInt(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        StringBuilder sb = new StringBuilder();
        int i = m - 1;
        int j = n - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int a = i < 0 ? 0 : num1.charAt(i) - '0';
            int b = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = a + b + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        if (carry == 1) sb.append(1);
        return sb.reverse().toString();
    }
}
