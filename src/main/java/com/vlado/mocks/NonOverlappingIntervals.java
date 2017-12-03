package com.vlado.mocks;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a collection of intervals, we need to find the minimum number of intervals to be removed to
 * make the rest of the intervals non-overlapping.
 */
public class NonOverlappingIntervals {

  public static void main(String[] args) {
    System.out.println(new NonOverlappingIntervals().eraseOverlapIntervals(new Interval[]{
        new Interval(1, 2),
        new Interval(2, 3),
        new Interval(3, 4),
        new Interval(1, 3)
    }));


    System.out.println(new NonOverlappingIntervals().eraseOverlapIntervals(new Interval[]{
        new Interval(1, 3),
        new Interval(2, 5),
        new Interval(4, 5),
        new Interval(6, 7),
        new Interval(6, 8),
        new Interval(7, 8)
    }));
  }

  public int eraseOverlapIntervals(Interval[] intervals) {
    if (intervals.length <= 1) {
      return intervals.length;
    }

    Arrays.sort(intervals, (o1, o2) -> o1.end - o2.end);

    int[] dp = new int[intervals.length];
    dp[0] = 1;
    for (int i = 1; i < dp.length; i++) {
      int currentMax = 0;
      for (int j = i - 1; j >= 0 ; j--) {
        if (!overlap(intervals[j], intervals[i])) {
          currentMax = dp[j];
          break;
        }
      }
      dp[i] = Math.max(currentMax + 1, dp[i - 1]);
    }

    return intervals.length - dp[dp.length - 1];
  }

  private boolean overlap(Interval start, Interval end) {
    return start.end > end.start;
  }

  static private class Interval {
    int start;
    int end;

    Interval() {
      this(0, 0);
    }

    Interval(int s, int e) {
      start = s;
      end = e;
    }

    @Override
    public String toString() {
      return start + " -> " + end;
    }
  }

}
