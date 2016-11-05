package com.vlado;

import java.util.*;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        System.out.println(new LowestCommonAncestor().lowestCommonAncestor(root, root.left, root.right));
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.equals(q)) {
            return p;
        }

        Deque<TreeNode> stack = new ArrayDeque();
        Map<TreeNode, TreeNode> nodes = new HashMap();
        stack.add(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                nodes.put(node.left, node);
                stack.add(node.left);
            }

            if (node.right != null) {
                nodes.put(node.right, node);
                stack.add(node.right);
            }
        }

        Set<TreeNode> ancestors = new HashSet<TreeNode>();
        TreeNode n = p;
        while (n != null) {
            ancestors.add(n);
            n = nodes.get(n);
        }

        n = q;
        while (!ancestors.contains(n)) {
            n = nodes.get(n);
        }

        return n;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public String toString() {
            return String.valueOf(val);
        }
    }
}

