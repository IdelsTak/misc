package com.vlado.linkedlist;

/**
 * Delete a node in the middle of a single linked list, given only access to that node
 * Given
 * <code>a -> b -> c -> d -> e -> f</code> and <code>c</code>, should return
 * <code>a -> b -> d -> e -> f</code>
 */
public class DeleteMiddleNode {


    public static void main(String[] args) {
        {
            LinkedListNode[] cs = arrayToLinkedList(new char[]{'a', 'b', 'c', 'd', 'e', 'f'}, 'c');
            System.out.print("Input: ");
            printLinkedList(cs[0]);
            System.out.println("Node to delete: " + cs[1].data);
            new DeleteMiddleNode().deleteNode(cs[1]);
            printLinkedList(cs[0]);
        }
        {
            LinkedListNode[] cs = arrayToLinkedList(new char[]{'a', 'b', 'c', 'd', 'e', 'f'}, 'e');
            System.out.print("Input: ");
            printLinkedList(cs[0]);
            System.out.println("Node to delete: " + cs[1].data);
            new DeleteMiddleNode().deleteNode(cs[1]);
            printLinkedList(cs[0]);
        }
    }

    boolean deleteNode(LinkedListNode n) {
        if (n == null || n.next == null) {
            return false;
        }
        LinkedListNode next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }

    static LinkedListNode[] arrayToLinkedList(char[] arr, char c) {
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
        char data;
        LinkedListNode next;
        LinkedListNode(char data) {
            this.data = data;
        }
    }
}
