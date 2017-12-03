package com.vlado.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * A linked list is given such that each node contains an additional random pointer which could
 * point to any node in the list or null. Return a deep copy of the list.
 */
public class RandomPointer {

  public static void main(String[] args) {
    RandomListNode head = new RandomListNode(1);
    RandomListNode tail1 = new RandomListNode(2);
    RandomListNode tail2 = new RandomListNode(3);
    head.next = tail1;
    tail1.next = tail2;
    head.random = tail2;
    tail1.random = head;

    new RandomPointer().copyRandomList(head);
  }

  public RandomListNode copyRandomList(RandomListNode head) {
    Map<Integer, RandomListNode> cache = new HashMap<>();

    RandomListNode temp = head;
    RandomListNode previous = null;
    while (temp!= null) {
      RandomListNode newRandomNode = new RandomListNode(temp.label);
      cache.put(temp.label, newRandomNode);
      if (previous != null) {
        previous.next = newRandomNode;
      }
      previous = newRandomNode;
      temp = temp.next;
    }

    RandomListNode result = cache.get(head.label);
    while (head!= null) {
      RandomListNode random = head.random;
      if (random != null) {
        RandomListNode node = cache.get(head.label);
        node.random = cache.get(random.label);
      }
      head = head.next;
    }

    return result;
  }

  static class RandomListNode {

    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
      this.label = x;
    }

    @Override
    public String toString() {
      return String.valueOf(label);
    }
  }

  ;

}
