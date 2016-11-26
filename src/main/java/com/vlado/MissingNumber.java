package com.vlado;

public class MissingNumber {

    public static void main(String[] args) {
        System.out.println(new MissingNumber().getMissingNumber(new int[]{1, 2, 4, 6, 3, 7, 8})); //should be 5
    }

    public int getMissingNumber(int[] arr) {

        int x1 = arr[0];
        int x2 = 1;

        for (int i = 1; i < arr.length; i++) {
            x1 = x1^arr[i];
        }

        for (int i = 2; i <= arr.length + 1; i++) {
            x2 = x2^i;
        }

        return x1 ^ x2;
    }
}
