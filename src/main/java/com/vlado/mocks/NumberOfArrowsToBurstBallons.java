package com.vlado.mocks;

import java.util.Arrays;
import java.util.Comparator;

/**
 * There are a number of spherical balloons spread in two-dimensional space. For each balloon,
 * provided input is the start and end coordinates of the horizontal diameter. Since it's
 * horizontal, y-coordinates don't matter and hence the x-coordinates of start and end of the
 * diameter suffice. Start is always smaller than end. There will be at most 104 balloons. An arrow
 * can be shot up exactly vertically from different points along the x-axis. A balloon with xstart
 * and xend bursts by an arrow shot at x if Xstart ≤ X ≤ Xend. There is no limit to the number of
 * arrows that can be shot. An arrow once shot keeps travelling up infinitely. The problem is to
 * find the minimum number of arrows that must be shot to burst all balloons.
 */
public class NumberOfArrowsToBurstBallons {

  public static void main(String[] args) {
    System.out.println(new NumberOfArrowsToBurstBallons()
        .findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6},
            {7, 12}}));
  }

  public int findMinArrowShots(int[][] points) {
    Arrays.sort(points, (a, b) -> {
      if (a[0] == b[0]) {
        return a[1] - b[1];
      } else {
        return a[0] - b[0];
      }
    });

    int minArrows = 1;
    int arrowLimit = points[0][1];
    for (int i = 1; i < points.length; i++) {
      int[] baloon = points[i];
      if (baloon[0] <= arrowLimit) {
        arrowLimit = Math.min(arrowLimit, baloon[1]);
      } else {
        minArrows++;
        arrowLimit = baloon[1];
      }
    }
    return minArrows;
  }
}
