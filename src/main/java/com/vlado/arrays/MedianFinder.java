package com.vlado.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 * Examples:
 * [2,3,4] , the median is 3
 * [2,3], the median is (2 + 3) / 2 = 2.5
 */
public class MedianFinder {

  public static void main(String[] args) {
    MedianFinder medianFinder = new MedianFinder();
    medianFinder.addNum(-1);
    System.out.println(medianFinder.findMedian());
    medianFinder.addNum(-2);
    System.out.println(medianFinder.findMedian());
    medianFinder.addNum(-3);
    System.out.println(medianFinder.findMedian());
    medianFinder.addNum(-4);
    System.out.println(medianFinder.findMedian());
    medianFinder.addNum(-5);
    System.out.println(medianFinder.findMedian());

  }

  PriorityQueue<Integer> hi; //min heap
  PriorityQueue<Integer> lo; //max heap

  public MedianFinder() {
    hi = new PriorityQueue<>((o1, o2) -> o1.compareTo(o2));
    lo = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
  }

  public void addNum(int num) {
    lo.add(num);
    hi.add(lo.poll());

    if (lo.size() < hi.size()) {
      lo.add(hi.poll());
    }
  }

  public double findMedian() {
    if (lo.size() > hi.size()) {
      return lo.peek();
    }
    return (lo.peek() + hi.peek()) * 0.5;
  }

}
