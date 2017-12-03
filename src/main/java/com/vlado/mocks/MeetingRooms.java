package com.vlado.mocks;

import java.util.Arrays;
import sun.jvm.hotspot.utilities.Interval;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]
 * (si < ei), determine if a person could attend all meetings.
 *
 * For example,
 * <pre>
 * Given [[0, 30],[5, 10],[15, 20]],
 * return false.
 * </pre>
 */
public class MeetingRooms {

  public static void main(String[] args) {
    System.out.println(new MeetingRooms().canAttendMeetings(new Interval[]{
        new Interval(0, 30),
        new Interval(5, 10),
        new Interval(15, 20)
    }));
  }

  public boolean canAttendMeetings(Interval[] intervals) {
    if (intervals.length <= 1) {
      return true;
    }

    Arrays.sort(intervals, (i1, i2) -> i1.start - i2.start);
    for (int i = 1; i < intervals.length; i++) {
      Interval current = intervals[i];
      Interval previous = intervals[i - 1];
      if (current.start < previous.end) {
        return false;
      }
    }
    return true;
  }

  private static class Interval {

    int start;
    int end;

    Interval(int s, int e) {
      start = s;
      end = e;
    }
  }
}
