package com.company;

public class ReadWriteBuf {
    char[] arr;
    int size;
    int count;
    int head;
    int tail;
    public ReadWriteBuf(int k){
        arr = new char[k];
        size = k;
        count = 0;
        head = 0;
        tail = -1;
    }
    public void addChar(char c) {
        tail = (tail + 1) % size;
        arr[tail] = c;
        count++;
    }
    public char popchar() {
        char ans = arr[head];
        head = (head + 1) % size;
        count--;
        return ans;
    }
    public int write(String s) {
        int i = 0;
        for (;i < s.length() && !isFull(); i++) {
            addChar(s.charAt(i));
        }
        return i;
    }
    public int read(char[] buf, int n) {
        int i = 0;
        for (; i < n && !isEmpty(); i++) {
            buf[i] = popchar();
        }
        return i;
    }
    public boolean isFull() {
        return count == size;
    }
    public boolean isEmpty() {
        return count == 0;
    }
    public static void main(String[] args) {
        int buffSize = 5;
        ReadWriteBuf reader = new ReadWriteBuf(buffSize);
        char[] buf = new char[buffSize];

        System.out.println(reader.write("abc"));

        System.out.println(reader.write("def"));

        int len = reader.read(buf, 3);
        for (int i = 0; i < len; i ++)
            System.out.print(buf[i] + " ");
        System.out.println();

        System.out.println(reader.write("xyzabc"));

        len = reader.read(buf, 8);
        for (int i = 0; i < len; i ++)
            System.out.print(buf[i] + " ");
        System.out.println();
    }
}
