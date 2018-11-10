package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class HtmlTree {
    class TreeNode {
        List<TreeNode> children;
        String tag;
        public TreeNode(String tag) {
            this.tag = tag;
            children = new ArrayList<>();
        }
    }
    public TreeNode build(String s) {
        if (s == null || s.length() == 0) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = null;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '>') continue;
            String tag = s.substring(left, i + 1);
            if (!stack.isEmpty() && stack.peek().tag.equals(tag)) {
                stack.pop();
            } else {
                TreeNode node = new TreeNode(tag);
                if (root != null) root = node;
                if (!stack.isEmpty()) {
                    stack.peek().children.add(node);
                }
                stack.push(node);
            }
        }
        return root;
    }
    public List<String> search(TreeNode root, String tag) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append('0').append("root.tag");
        dfs(ans, sb, root, tag);
        return ans;
    }
    public void dfs(List<String> ans, StringBuilder sb, TreeNode root, String target) {
        if (root == null) return;
        if (root.tag.equals(target)) {
            ans.add(sb.toString());
        }
        int len = sb.length();
        for (int i = 0; i < root.children.size(); i++) {
            sb.append(i).append(':').append(root.children.get(i).tag);
        }
    }
}
