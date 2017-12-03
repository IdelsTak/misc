package com.vlado.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land)
 * connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid
 * are surrounded by water.
 */
public class DistinctIslands {

  public static void main(String[] args) {
    int[][] grid = new int[][] {
        {1, 1, 0, 0, 0},
        {1, 0, 0, 0, 0},
        {0, 0, 0, 0, 1},
        {0, 0, 0, 1, 1},
    };

    DistinctIslands distinctIslands = new DistinctIslands();
    System.out.println(distinctIslands.numDistinctIslands2(grid));
  }

  int[][] grid;
  boolean[][] seen;
  ArrayList<Integer> shape;

  public void explore(int r, int c) {
    if (0 <= r && r < grid.length && 0 <= c && c < grid[0].length &&
        grid[r][c] == 1 && !seen[r][c]) {
      seen[r][c] = true;
      shape.add(r * grid[0].length + c);
      explore(r + 1, c);
      explore(r - 1, c);
      explore(r, c + 1);
      explore(r, c - 1);
    }
  }

  public String canonical(ArrayList<Integer> shape) {
    String ans = "";
    int lift = grid.length + grid[0].length;
    int[] out = new int[shape.size()];
    int[] xs = new int[shape.size()];
    int[] ys = new int[shape.size()];

    for (int c = 0; c < 8; ++c) {
      int t = 0;
      for (int z : shape) {
        int x = z / grid[0].length;
        int y = z % grid[0].length;
        //x y, x -y, -x y, -x -y
        //y x, y -x, -y x, -y -x
        xs[t] = c <= 1 ? x : c <= 3 ? -x : c <= 5 ? y : -y;
        ys[t++] = c <= 3 ? (c % 2 == 0 ? y : -y) : (c % 2 == 0 ? x : -x);
      }

      int mx = xs[0], my = ys[0];
      for (int x : xs) {
        mx = Math.min(mx, x);
      }
      for (int y : ys) {
        my = Math.min(my, y);
      }

      for (int j = 0; j < shape.size(); ++j) {
        out[j] = (xs[j] - mx) * lift + (ys[j] - my);
      }
      Arrays.sort(out);
      String candidate = Arrays.toString(out);
      if (ans.compareTo(candidate) < 0) {
        ans = candidate;
      }
    }
    return ans;
  }

  public int numDistinctIslands2(int[][] grid) {
    this.grid = grid;
    seen = new boolean[grid.length][grid[0].length];
    Set shapes = new HashSet<String>();

    for (int r = 0; r < grid.length; ++r) {
      for (int c = 0; c < grid[0].length; ++c) {
        shape = new ArrayList();
        explore(r, c);
        if (!shape.isEmpty()) {
          shapes.add(canonical(shape));
        }
      }
    }

    return shapes.size();
  }
}
