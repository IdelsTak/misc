package com.vlado.linkedlist;

import java.util.HashSet;

/**
 * Write code to remove duplicates from an unsorted linked list.
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        LinkedListNode start = arrayToLinkedList(new int[]{1, 2, 3, 4, 4, 4, 4, 5});
        new RemoveDuplicates().deleteDuplicatesUsingHash(start);
        printLinkedList(start);

        System.out.println();

        start = arrayToLinkedList(new int[]{1, 2, 3, 4, 4, 4, 4, 5});
        new RemoveDuplicates().deleteDuplicatesUsingRunner(start);
        printLinkedList(start);
    }

    void deleteDuplicatesUsingRunner(LinkedListNode n) {
        LinkedListNode current = n;
        while (current != null) {
            LinkedListNode runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    void deleteDuplicatesUsingHash(LinkedListNode n) {
        HashSet<Integer> integers = new HashSet<>();

        LinkedListNode prev = null;

        while (n != null) {
            if (integers.contains(n.data)) {
                prev.next = n.next;
            } else {
                integers.add(n.data);
                prev = n;
            }
            n = n.next;
        }
    }

    static LinkedListNode arrayToLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        LinkedListNode start = new LinkedListNode(arr[0]);
        if (arr.length > 1) {
            LinkedListNode last = start;
            for (int i = 1; i < arr.length; i++) {
                LinkedListNode node = new LinkedListNode(arr[i]);
                last.next = node;
                last = node;
            }
        }
        return start;
    }

    static void printLinkedList(LinkedListNode n) {
        while (n != null) {
            System.out.println(n.data);
            n = n.next;
        }
    }

    static class LinkedListNode {
        int data;
        LinkedListNode next;

        LinkedListNode(int data) {
            this.data = data;
        }
    }
}
