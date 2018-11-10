package com.company;

import java.util.Iterator;
import java.util.Stack;


public class BSTIterator {
    Stack<TreeNode> stack;
    TreeNode lastVisited;
    TreeNode root;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        lastVisited = null;
        this.root = root;
    }
    public boolean hasNext() {
        return !stack.isEmpty() || root != null;
    }
//    public Integer next() {
//        Integer ans = null;
//        while (ans == null) {
//            while (root != null) {
//                stack.push(root);
//                root = root.left;
//            }
//            if (stack.peek().right == null || stack.peek().right == lastVisited) {
//                lastVisited = stack.pop();
//                ans = lastVisited.val;
//            } else {
//                root = stack.peek().right;
//            }
//        }
//        return ans;
//    }
    public Integer next() {
        Integer ans = null;
        while (ans == null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.peek().right == null || stack.peek().right == lastVisited) {
                lastVisited  = stack.pop();
                ans = lastVisited.val;
            } else {
                root = stack.peek().right;
            }
        }
        return ans;
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
