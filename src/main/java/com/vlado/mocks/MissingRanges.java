package com.vlado.mocks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Given a sorted integer array where the range of elements are in the inclusive range [lower,
 * upper], return its missing ranges. For example, given [0, 1, 3, 50, 75], lower = 0 and upper =
 * 99, return ["2", "4->49", "51->74", "76->99"].
 */
public class MissingRanges {

  public static void main(String[] args) {
    int[] nums = {0,1,3,50,75};
    System.out.println(new MissingRanges().findMissingRanges(nums, 0, 99));

    nums = new int[0];
    System.out.println(new MissingRanges().findMissingRanges(nums, 1, 1));

    nums = new int[0];
    System.out.println(new MissingRanges().findMissingRanges(nums, -3, -1));
  }

  public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    Set<Integer> numSet = new HashSet<>();
    Arrays.stream(nums).forEach(numSet::add);

    List<String> result = new LinkedList<>();

    if (lower == upper && !numSet.contains(lower)) {
      result.add(String.valueOf(lower));
      return result;
    }

    int startRange = lower;
    int endRange = lower;

    for (int i = lower; i <= upper; i++) {
      if (numSet.contains(i)) {
        if (endRange - startRange > 1) {
          result.add(String.format("%d->%d", startRange + 1, endRange));
        } else if (endRange-startRange == 1) {
          result.add(String.valueOf(endRange));
        }
        startRange = endRange = i;
      } else {
        endRange++;
      }
    }

    if (endRange - startRange > 1) {
      result.add(String.format("%d->%d", startRange + 1, endRange));
    } else if (endRange-startRange == 1) {
      result.add(String.valueOf(startRange));
    }

    return result;
  }
}
