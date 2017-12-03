package com.vlado.arrays;

public class HopperProblem {

  public static void main(String[] args) {
    HopperProblem hp = new HopperProblem();

    System.out.println(hp.isHoppable(new int[]{4, 2, 0, 0, 2, 0}));
    System.out.println(hp.isHoppable(new int[]{1, 1, 2, 3, 0, 0, 0, 0, 0, 0}));
  }


  public boolean isHoppable(int[] arr) {
    if (arr == null || arr.length == 0) {
      return false;
    }
    return helper(arr, 0);
  }

  private boolean helper(int[] arr, int index) {
    int hops = arr[index];
    if (hops + index > arr.length - 1) {
      return true;
    }
    else {
      for (int i = 1; i <= hops; i++) {
        if (helper(arr, index + i)) {
          return true;
        }
      }
      return false;
    }
  }

}
