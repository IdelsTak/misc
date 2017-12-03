package com.vlado.mocks;

import java.util.LinkedList;

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 * <p>
 * Example:
 * </p>
 *
 * <pre>
 *   MovingAverage m = new MovingAverage(3);
 *   m.next(1) = 1;
 *   m.next(10) = (1 + 10) / 2;
 *   m.next(3) = (1 + 10 + 3) / 3;
 *   m.next(5) = (10 + 3 + 5) / 3;
 * </pre>
 */
public class MovingAverage {

  public static void main(String[] args) {
    MovingAverage ma = new MovingAverage(3);
    System.out.println(ma.next(1));
    System.out.println(ma.next(10));
    System.out.println(ma.next(3));
    System.out.println(ma.next(5));
  }

  private int maxSize;
  private LinkedList<Integer> elements;
  private double currentSum;

  /** Initialize your data structure here. */
  public MovingAverage(int size) {
    this.maxSize = size;
    this.elements = new LinkedList<>();
    this.currentSum = 0;
  }

  public double next(int val) {
    if (elements.size() == maxSize) {
      Integer first = elements.removeFirst();
      currentSum -= first;
    }
    currentSum += val;
    elements.add(val);
    return currentSum / elements.size();
  }
}
