package com.company;


// Binary Tree : 549. Binary Tree Longest Consecutive Sequence II
//这里是BST
public class BSTLongestIncPath {
    static int max;
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node6.left = node3;
        node3.left = node2;
        node3.right = node4;
        node2.left = node1;
        node4.right = node5;
        System.out.println(longestPath(node6));
    }
    public static int longestPath(TreeNode root) {
        max = 0;
        if (root == null) return 0;
        singlePath(root);
        return max;
    }
    // {leftPath, rightPath};
    public static int[] singlePath(TreeNode root) {
        int[] ans = new int[2];
        if (root == null) {
            return ans;
        }
        int[] left = singlePath(root.left);
        int[] right = singlePath(root.right);
        max = Math.max(max, left[0] + 1 + right[1]);
        ans[0] = 1 + left[0];
        ans[1] = 1 + right[1];
        return ans;
    }
    static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
