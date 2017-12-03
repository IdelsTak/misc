package com.vlado.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of
 * favorite restaurants represented by strings. You need to help them find out their common interest
 * with the least list index sum. If there is a choice tie between answers, output all of them with
 * no order requirement. You could assume there always exists an answer.
 *
 * Input:
 *  ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 *  ["KFC", "Shogun", "Burger King"]
 *
 * Output: ["Shogun"]
 *
 * Explanation: The restaurant they both like and have the least index sum is
 * "Shogun" with index sum 1 (0+1).
 */
public class MinimumIndexSumOfLists {

  public static void main(String[] args) {
    String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
    String[] list2 = {"KFC", "Shogun", "Burger King"};
    System.out.println(Arrays.toString(new MinimumIndexSumOfLists().findRestaurant(list1, list2)));
  }

  public String[] findRestaurant(String[] list1, String[] list2) {
    int end = Math.max(list1.length, list2.length);
    Map<String, Integer> restaurants = new HashMap<>();

    for (int j = 0; j < end; j++) {
      if (j < list1.length) {
        restaurants.put(list1[j], j);
      }
    }

    List<String> result = new ArrayList<>();
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < list2.length; i++) {
      if (restaurants.containsKey(list2[i])) {
        int sum = restaurants.get(list2[i]) + i;
        if (sum < min) {
          result.clear();
          result.add(list2[i]);
          min = sum;
        } else if (sum == min) {
          result.add(list2[i]);
        }
      }
    }

    return result.toArray(new String[0]);
  }
}
