package com.vlado.bits;

/**
 * Find duplicate numbers
 */
public class FindDuplicates {

  public static void main(String[] args) {
    new FindDuplicates().printDuplicates(new int[]{1, 2, 3, 4, 5, 4, 6, 7, 7});
  }

  void printDuplicates(int[] numbers) {
    BitSet bs = new BitSet(numbers.length);

    for (int num : numbers) {
      if (bs.get(num)) {
        System.out.println(String.format("%d is duplicate.", num));
      } else {
        bs.set(num);
      }
    }
  }

  private static class BitSet {
    int[] bitset = null;
    BitSet(int size) {
      bitset = new int[(size >> 5) + 1];
    }

    public boolean get(int pos) {
      int bitNumber = 1 << pos;
      return (bitset[pos >> 5] & bitNumber) != 0;
    }

    public void set(int pos) {
      int bitNumber = 1 << pos;
      bitset[pos >> 5] |= bitNumber ;
    }
  }
}
