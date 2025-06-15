package com.eric.algorithm.数组中最长山峰;

/**
 * <p>
 * TODO
 * </p>
 *
 * @author Eric Jin
 * @since 6/15/25 AM9:56
 */
public class MaxSolution {

    public static int longestMountain(int[] arr) {
        if (arr == null || arr.length < 3) {
            return 0;
        }

        int maxLength = 0;
        int[] peekLeft = new int[arr.length], peekRight = new int[arr.length];
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                peekRight[i] = peekRight[i + 1] + 1;
            }
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                peekLeft[i] = peekLeft[i - 1] + 1;
            }
            if (peekLeft[i] > 0 && peekRight[i] > 0) {
                maxLength = Math.max(maxLength, peekLeft[i] + peekRight[i] + 1);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestMountain(new int[]{2, 1, 4, 7, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5}));
    }
}
