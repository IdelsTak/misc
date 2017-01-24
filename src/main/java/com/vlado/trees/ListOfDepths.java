package com.vlado.trees;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Given a binary tree, design an algorithm, which creates a
 * linked list of all the nodes at each depth
 */
public class ListOfDepths {

    public static void main(String[] args) {
        TreeNode root = new MinimalTree().createMinimalBST(new int[]{1, 2, 3, 4, 5, 6, 7});

        ArrayList<LinkedList<TreeNode>> res = new ListOfDepths().createLevelLinkedList(root);
        System.out.println(res.get(0).toString()); //[4]
        System.out.println(res.get(1).toString()); //[2, 6]
        System.out.println(res.get(2).toString()); //[1, 3, 5, 7]
    }

    public ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> list = new ArrayList<LinkedList<TreeNode>>();
        createLevelLinkedList(root, list, 0);
        return list;
    }

    public void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
        if (root == null) {
            return;
        }
        if (lists.size() == level) {
            lists.add(new LinkedList<TreeNode>());
        }
        lists.get(level).add(root);

        createLevelLinkedList(root.left(), lists, level + 1);
        createLevelLinkedList(root.right(), lists, level + 1);
    }
}
