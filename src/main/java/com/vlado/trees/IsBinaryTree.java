package com.vlado.trees;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return true if it is binary search tree else return false.
 */
public class IsBinaryTree {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(0);
    root.left.right = new TreeNode(21);
    root.left.left = new TreeNode(-1);

    root.right = new TreeNode(25);
    root.right.left = new TreeNode(16);
    root.right.right = new TreeNode(32);

    IsBinaryTree tree = new IsBinaryTree();

    System.out.println(tree.isBinary(root));

  }

  boolean isBinary(TreeNode root) {
    return isBinary(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private boolean isBinary(TreeNode root, int min, int max) {
    if (root == null) {
      return true;
    }

    if (root.value < min || root.value > max) {
      return false;
    }

    return isBinary(root.left, min, root.value) && isBinary(root.right, root.value, max);
  }

  private static class TreeNode {

    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
      this.value = value;
    }

    boolean isLeaf() {
      return this.left == null && this.right == null;
    }
  }
}
