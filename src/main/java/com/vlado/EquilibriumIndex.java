package com.vlado;

public class EquilibriumIndex {

    public static void main(String[] args) {
        int[] arr = {-1, 3, -4, 5, 1, -6, 2, 1};

        System.out.println(solution(arr));
    }

    public static int solution(int[] arr) {
        int result = -1;

        int sumRight = 0;
        int sumLeft = 0;

        for (int i = 0; i < arr.length; i++) {
            sumRight += arr[i];
        }

        for (int i = 0; i < arr.length; i ++) {
            int tempRight = sumRight - arr[i];

            if (tempRight == sumLeft) {
                result = i;
                break;
            } else {
                sumLeft += arr[i];
                sumRight = tempRight;
            }
        }

        return result;
    }
}
