package com.vlado.mocks;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]
 * (Si < Ei), find the minimum number of conference rooms required.
 *
 * <p>
 * For example, Given [[0, 30],[5, 10],[15, 20]], return 2.
 * </p>
 */
public class MeetingRoomsII {

  public static void main(String[] args) {
    System.out.println(new MeetingRoomsII().minMeetingRooms(new Interval[]{
        new Interval(0, 30),
        new Interval(5, 10),
        new Interval(15, 20)
    })); //Should be 2

    System.out.println(new MeetingRoomsII().minMeetingRooms(new Interval[]{
        new Interval(9, 10),
        new Interval(4, 9),
        new Interval(4, 17)
    })); //Should be 2

    System.out.println(new MeetingRoomsII().minMeetingRooms(new Interval[]{
        new Interval(2, 11),
        new Interval(6, 16),
        new Interval(11, 16)
    })); //Should be 2

    System.out.println(new MeetingRoomsII().minMeetingRooms(new Interval[]{
        new Interval(1, 2),
        new Interval(2, 3),
        new Interval(3, 4)
    })); //Should be 1
  }

  public int minMeetingRooms(Interval[] intervals) {
    //Sort intervals by start time
    Arrays.sort(intervals, (a, b) -> a.start - b.start);

    //Using a min heap to track the minimum end time
    PriorityQueue<Interval> pq = new PriorityQueue<>((o1, o2) -> o1.end - o2.end);

    pq.add(intervals[0]);
    for (int i = 1; i < intervals.length; i++) {
      Interval current = intervals[i];

      if (current.start >= pq.peek().end) {
        pq.remove();
      }
      pq.add(current);
    }

    return pq.size();
  }

  private static class Interval {
    int start;
    int end;
    Interval(int s, int e) {
      start = s;
      end = e;
    }
    @Override
    public String toString() {
      return String.format("[%d, %d]", start, end);
    }
  }
}
