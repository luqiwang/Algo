package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CutTree {
    static class TreeNode {
        List<TreeNode> children;
	    public TreeNode () {
	        children = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        TreeNode c1 = new TreeNode();
        TreeNode c2 = new TreeNode();
        TreeNode c3 = new TreeNode();
        TreeNode c4 = new TreeNode();
        TreeNode c5 = new TreeNode();
        root.children.add(c1);
        root.children.add(c2);
        root.children.add(c3);
        root.children.add(c4);
        c1.children.add(c5);
        List<TreeNode> ans = breakTree(root);
        System.out.println(ans.size());
    }

    public static List<TreeNode> breakTree(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        dfs(ans, root);
        return ans;
    }
    public static int dfs(List<TreeNode> ans, TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 1;
        //不能用for(TreeNode : root.children): 这样使用remove会ConcurrentModificationException
        for (int i = 0; i < root.children.size(); i++) {
            TreeNode child = root.children.get(i);
            int cur = dfs(ans, child);
            count += cur;
            if (cur == 0) {
                root.children.remove(child);
                i--;
            }
        }
        if (count % 2 == 0){
            ans.add(root);
            return 0;
        } else{
            return count;
        }
    }
}
