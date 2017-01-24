package com.vlado.trees;

/**
 * Given a sorted array, with unique integers,
 * write an algorithm to create a binary search tree
 */
public class MinimalTree {

    public static void main(String[] args) {
        System.out.println(new MinimalTree().createMinimalBST(new int[]{1, 2, 3, 4, 5, 6, 7})); //4
    }

    TreeNode createMinimalBST(int[] arr) {
        return createMinimalBST(arr, 0, arr.length - 1);
    }

    private TreeNode createMinimalBST(int[] arr, int start, int end) {
        if (end < start) {
            return null;
        }

        int mid = (start + end) / 2;

        TreeNode n = new TreeNode(arr[mid]);
        n.addLeft(createMinimalBST(arr, start, mid - 1));
        n.addRight(createMinimalBST(arr, mid + 1, end));
        return n;
    }
}
