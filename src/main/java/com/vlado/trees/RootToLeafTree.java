package com.vlado.trees;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree and a sum, find if there is a path from root to leaf which sums to this sum.
 */
public class RootToLeafTree {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(16);
    root.left.right = new TreeNode(-3);
    root.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(11);

    RootToLeafTree tree = new RootToLeafTree();
    List<Integer> result = new LinkedList<>();
    boolean exists = tree.rootToLeafSum(root, 26, result);
    if (exists) {
      System.out.println(result.toString());
    } else {
      System.out.println("No such combination..");
    }
  }

  boolean rootToLeafSum(TreeNode root, int remainder, List<Integer> result) {
    if (root == null) {
      return false;
    }
    if (root.isLeaf()) {
      if (root.value == remainder) {
        result.add(root.value);
        return true;
      } else {
        return false;
      }
    } else if (rootToLeafSum(root.left, remainder - root.value, result) || rootToLeafSum(root.right,
        remainder - root.value, result)) {
      result.add(root.value);
      return true;
    }
    return false;
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
