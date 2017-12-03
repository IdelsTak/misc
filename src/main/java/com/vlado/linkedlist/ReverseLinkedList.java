package com.vlado.linkedlist;

/**
 * Created by vdimitrov on 11/4/17.
 */
public class ReverseLinkedList {

  public static void main(String[] args) {
    ListNode node = new ListNode(1);
    node.next = new ListNode(2);
    node.next.next = new ListNode(3);

    print(node);

    ListNode reversed = new ReverseLinkedList().reverseList(node);
    print(reversed);

  }

  private ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode current = head;
    while(current != null) {
      ListNode nextTemp = current.next;
      current.next = prev;
      prev = current;
      current = nextTemp;
    }
    return prev;
  }

  private static void print(ListNode node) {
    while (node!= null) {
      System.out.print(node.val + " -> ");
      node = node.next;
    }
    System.out.println();
  }

  static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }

    @Override
    public String toString() {
      return String.valueOf(val);
    }
  }

}

