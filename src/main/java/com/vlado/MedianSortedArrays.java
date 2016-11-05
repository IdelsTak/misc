package com.vlado;

import java.util.Arrays;

/**
 * Created by vdimitrov on 10/1/16.
 */
public class MedianSortedArrays {

    public static void main(String[] args) {
//        System.out.println(new MedianSortedArrays().findMedianSortedArrays(new int[]{}, new int[]{1}));
//        System.out.println(new MedianSortedArrays().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
//        System.out.println(new MedianSortedArrays().findMedianSortedArrays(new int[]{1, 2}, new int[]{1, 2, 3}));
//        System.out.println(new MedianSortedArrays().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
//        System.out.println(new MedianSortedArrays().findMedianSortedArrays(new int[]{100000}, new int[]{100001}));
//        System.out.println(new MedianSortedArrays().findMedianSortedArrays(new int[]{1}, new int[]{2, 3}));
        System.out.println(new MedianSortedArrays().findMedianSortedArrays(new int[]{1, 1}, new int[]{1, 2}));

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        while (true) {
            if (nums1.length == 0) {
                return median(nums2);
            }

            if (nums2.length == 0) {
                return median(nums1);
            }

            double med1 = median(nums1);
            double med2 = median(nums2);
            if (med1 == med2) {
                return med1;
            }

            if (nums1.length > 2 && nums2.length > 2) {
                if (med1 < med2) {
                    nums1 = clipLeft(nums1);
                    nums2 = clipRight(nums2);
                } else {
                    nums1 = clipRight(nums1);
                    nums2 = clipLeft(nums2);
                }
                continue;
            }

            if (nums1.length == nums2.length) {
                return (median(nums1) + median(nums2))/2;
            }

            if (nums1.length > nums2.length) {
                if (nums2[0] < nums1[0]) return (nums1[0]);
                if (nums2[0] < nums1[1]) return (nums1[1]);
                return nums2[0];
            }

            if (nums1[0] < nums2[0]) return (nums2[0]);
            if (nums1[0] < nums2[1]) return (nums2[1]);
            return nums2[0];

        }
    }

    private int[] clipLeft(int[] src) {
        int[] newNums1 = new int[src.length - 1];
        System.arraycopy(src, 1, newNums1, 0, newNums1.length);
        return newNums1;
    }

    private int[] clipRight(int[] src) {
        int[] newNums1 = new int[src.length - 1];
        System.arraycopy(src, 0, newNums1, 0, newNums1.length);
        return newNums1;
    }

    private double median(int[] arr) {
        double med = 0d;
        if (arr.length % 2 == 0) {
            med = (double)(arr[arr.length/2] + arr[arr.length/2 - 1])/2;
        } else {
            med = arr[arr.length/2];
        }
        return med;
    }
}
