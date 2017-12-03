package com.vlado.arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * You are asked to cut off trees in a forest for a golf event. The forest is represented as a non-negative 2D map, in this map:

 0 represents the obstacle can't be reached.
 1 represents the ground can be walked through.
 The place with number bigger than 1 represents a tree can be walked through, and this positive number represents the tree's height.
 You are asked to cut off all the trees in this forest in the order of tree's height - always cut off the tree with lowest height first. And after cutting, the original place has the tree will become a grass (value 1).

 You will start from the point (0, 0) and you should output the minimum steps you need to walk to cut off all the trees. If you can't cut off all the trees, output -1 in that situation.

 You are guaranteed that no two trees have the same height and there is at least one tree needs to be cut off.
 */
public class GolfEvent {


  public static void main(String[] args) {
    int[][] input = new int[][] {
        {1, 2, 3},
        {0, 0, 4},
        {7, 6, 5}
    };
    System.out.println(new GolfEvent().cutOffTree(asLists(input)));

    input = new int[][] {
        {2, 3, 4},
        {0, 0, 5},
        {8, 7, 6}
    };
    System.out.println(new GolfEvent().cutOffTree(asLists(input)));

    input = new int[][] {
        {1, 2, 3},
        {0, 0, 0},
        {7, 6, 5}
    };
    System.out.println(new GolfEvent().cutOffTree(asLists(input)));
  }

  int steps = 0;
  boolean[][] seen;

  public int cutOffTree(List<List<Integer>> forest) {
    seen = new boolean[forest.size()][forest.get(0).size()];
    if (forest.get(0).get(0) > 1) {
      forest.get(0).set(0, 1);
    }
    if (forest.get(0).get(0) > 0 ) {
      dfsFill(forest, 0, 0);
    }
    if (!seen[forest.size() - 1][forest.get(0).size() -1]) {
      return -1;
    }
    return steps;
  }

  public void dfsFill(List<List<Integer>> grid, int i, int j) {
    if (i >= 0 &&
        j >= 0 &&
        i < grid.size() &&
        j < grid.get(0).size() &&
        grid.get(i).get(j) > 0 &&
        !seen[i][j]) {

      seen[i][j] = true;
      if (grid.get(i).get(j) > 1) {
        //Cut off tree
//        grid[i][j] = 1;
        steps++;
      }

      dfsFill(grid, i + 1, j);
      dfsFill(grid, i - 1, j);
      dfsFill(grid, i, j + 1);
      dfsFill(grid, i, j - 1);
    }
  }

  static List<List<Integer>> asLists(int[][] data) {
    List<List<Integer>> result = new LinkedList<>();
    for (int i = 0; i < data.length; i++) {
      result.add(new LinkedList<>());
      for (int j = 0; j < data[0].length; j++) {
        result.get(i).add(data[i][j]);
      }
    }
    return result;
  }
}
