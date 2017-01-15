package com.vlado.linkedlist;

/**
 * Determine if two singly linked lists intersect (by reference)
 *
 * Intersecting lists:
 * 3 -> 1 -> 5 -> 9 -> 7 -> 2 -> 1
 *                    /
 *              4 -> 6
 */
public class Intersection {

    public static void main(String[] args) {
        //Builds a list and returns the tail and the value 7 reference
        LinkedListNode[] list1 = arrayToLinkedList(new int[]{3, 1, 5, 9, 7, 2, 1}, 7);
        //Builds a list and returns the tail and the value 6 reference
        LinkedListNode[] list2 = arrayToLinkedList(new int[]{3, 6}, 6);
        //Intersect the lists
        list2[1].next = list1[1];

        System.out.println(new Intersection().findIntersection(list1[0], list2[0]).data); //7
    }

    LinkedListNode findIntersection(LinkedListNode list1, LinkedListNode list2) {
        if (list1 == null || list2 == null) {
            return null;
        }

        //Get tails and sizes
        Result result1 = getTailAndSize(list1);
        Result result2 = getTailAndSize(list2);

        // If tail references are not equal, no intersection
        if (result1.tail != result2.tail) {
            return null;
        }

        LinkedListNode shorter = result1.size < result2.size ? list1 : list2;
        LinkedListNode longer = result1.size < result2.size ? list2 : list1;

        //Get rid of the first k elements of the longer list
        longer = getKthElement(longer, Math.abs(result1.size - result2.size));

        //Advance both lists
        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }

        return shorter;
    }

    Result getTailAndSize(LinkedListNode list) {
        if (list == null) {
            return null;
        }
        int size = 1;
        LinkedListNode current = list;
        while (current.next != null) {
            current = current.next;
            size++;
        }
        return new Result(current, size);
    }

    LinkedListNode getKthElement(LinkedListNode head, int k) {
        LinkedListNode current = head;
        while (k > 0 && current != null) {
            k--;
            current = current.next;
        }
        return current;
    }

    class Result {
        int size;
        LinkedListNode tail;

        public Result(LinkedListNode tail, int size) {
            this.size = size;
            this.tail = tail;
        }
    }

    static LinkedListNode[] arrayToLinkedList(int[] arr, int c) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        LinkedListNode start = new LinkedListNode(arr[0]);
        LinkedListNode result = null;
        if (arr.length > 1) {
            LinkedListNode last = start;
            for (int i = 1; i < arr.length; i++) {
                LinkedListNode node = new LinkedListNode(arr[i]);
                last.next = node;
                last = node;
                if (arr[i] == c) {
                    result = node;
                }
            }
        }
        return new LinkedListNode[]{start, result};
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
