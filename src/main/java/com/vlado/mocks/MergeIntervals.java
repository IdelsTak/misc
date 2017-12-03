package com.vlado.mocks;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * For example:
 * <pre>
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 * </pre>
 */
public class MergeIntervals {

  public static void main(String[] args) {
    List<Interval> input = new LinkedList<>();
    input.add(new Interval(1, 3));
    input.add(new Interval(2, 6));
    input.add(new Interval(8, 10));
    input.add(new Interval(15, 18));

    List<Interval> out = new MergeIntervals().merge(input); //Should be [1, 6] [8, 10] [15, 18]
    for (Interval i : out) {
      System.out.print(String.format("[%d, %d] ", i.start, i.end));
    }

    System.out.println();

    input = new LinkedList<>();
    input.add(new Interval(1, 4));
    input.add(new Interval(4, 5));

    out = new MergeIntervals().merge(input); //Should be [1, 5]
    for (Interval i : out) {
      System.out.print(String.format("[%d, %d] ", i.start, i.end));
    }

    System.out.println();

    input = new LinkedList<>();
    input.add(new Interval(1, 4));
    input.add(new Interval(2, 3));

    out = new MergeIntervals().merge(input); //Should be [1, 4]
    for (Interval i : out) {
      System.out.print(String.format("[%d, %d] ", i.start, i.end));
    }
  }

  public List<Interval> merge(List<Interval> intervals) {
    if (intervals.size() <= 1) {
      return intervals;
    }
    Collections.sort(intervals, (i1, i2) -> i1.start - i2.start);

    Interval previous = intervals.get(0);
    List<Interval> result = new LinkedList<>();

    for (int i = 1; i < intervals.size(); i++) {
      Interval current = intervals.get(i);
      if (current.start <= previous.end) {
        previous.end = Math.max(current.end, previous.end);
      } else {
        result.add(previous);
        previous = current;
      }
    }


    if (result.size() > 0) {
      Interval lastFromList = result.get(result.size() - 1);
      if (previous.start <= lastFromList.end) {
        previous.end = Math.max(lastFromList.end, previous.end);
      } else {
        result.add(previous);
      }
    } else {
      result.add(previous);
    }
    return result;
  }

  private static class Interval {

    int start;
    int end;

    Interval() {
      this(0, 0);
    }

    Interval(int s, int e) {
      start = s;
      end = e;
    }
  }
}
