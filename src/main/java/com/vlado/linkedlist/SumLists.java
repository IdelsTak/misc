package com.vlado.linkedlist;

/**
 * Two numbers are represented as linked lists - each digit is a node of a linked list
 * Implement a function that adds the two numbers and returns the sum as a linked list
 */
public class SumLists {

    public static void main(String[] args) {
        LinkedListNode l1 = arrayToLinkedList(7, 1, 6);//617 +
        LinkedListNode l2 = arrayToLinkedList(5, 9, 2);//295

        LinkedListNode result = new SumLists().addLists(l1, l2, 0);
        printLinkedList(result); //219
    }

    LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        int sum = carry;
        if (l1 != null) {
            sum += l1.data;
        }
        if (l2 != null) {
            sum += l2.data;
        }
        LinkedListNode result = new LinkedListNode(sum % 10);

        if (l1.next != null || l2.next != null) {
            result.next = addLists(l1.next, l2.next, sum > 10 ? 1 : 0);
        }
        return result;
    }

    static LinkedListNode arrayToLinkedList(int... arr) {
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
            if (n.next != null) {
                System.out.print(n.data + " -> ");
            } else {
                System.out.print(n.data);
            }
            n = n.next;
        }
        System.out.println();
    }

    static class LinkedListNode {
        int data;
        LinkedListNode next;

        LinkedListNode(int data) {
            this.data = data;
        }
    }
}
