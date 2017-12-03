package com.vlado.mocks;

import java.util.Arrays;

/**
 * Created by vdimitrov on 11/21/17.
 */
public class AtmMachine {

  private final int[] banknotes;
  private final int[] denom;

  // Imagine you are an ATM Machine
  // Leva bills/banknotes are of 2, 5, 10, 20, 50, 100 leva value
  // The machine has the following number of those bills
  // 91 bills of value 2, 26 of value 5, ... 10 of value 100
  // Write a function that similarly returns an array of counts
  // of bills that add up to the requested by user value
  // example solutions are (there can be others):
  // giveBack(75) =>  {0, 1, 0, 1, 1, 0}
  // giveBack(30) =>  {0, 6, 0, 0, 0, 0}
  // You can choose to change the structure, function names, arguments
  // if you think they will better fit your solution.

  public static void main(String[] args) {
    AtmMachine atm = new AtmMachine(new int[]{91, 26, 83, 1, 3, 1});

    int[] case1 = atm.giveBack(30);
    int[] case2 = atm.giveBack(75);
    int[] case3 = atm.giveBack(8);
    int[] case4 = atm.giveBack(400);

    System.out.println("30 -> " + Arrays.toString(case1));
    System.out.println("75 -> " + Arrays.toString(case2));
    System.out.println("8 -> " + Arrays.toString(case3));
    System.out.println("400 -> " + Arrays.toString(case4));
  }

  public AtmMachine(int[] banknotes) {
    this.banknotes = banknotes;
    this.denom = new int[]{2, 5, 10, 20, 50, 100};
  }

  public int[] giveBack(int amount) {
    int[] noteArr = new int[]{0, 0, 0, 0, 0, 0}; //5 possible banknotes
    withdraw(amount, noteArr);
    return noteArr;
  }

  public boolean withdraw(int remainder, int[] noteArray) {
    if (remainder == 1 || remainder < 0) {
      return false;
    } else if (remainder == 0) {
      return true;
    }
    for (int i = denom.length - 1; i >= 0 ; i--) {
      if (remainder / denom[i] > 0 && banknotes[i] > 0) {
        banknotes[i]--;
        boolean right = withdraw(remainder - denom[i], noteArray);
        if (right) {
          noteArray[i] ++;
          return true;
        } else {
          banknotes[i]++;
        }
      }
    }
    return false;
  }

}
