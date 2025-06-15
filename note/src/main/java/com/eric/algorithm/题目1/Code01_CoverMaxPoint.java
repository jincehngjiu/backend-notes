package com.eric.algorithm.题目1;

/**
 * <p>
 * TODO
 * </p>
 *
 * @author Eric Jin
 * @since 6/15/25 PM10:05
 */
public class Code01_CoverMaxPoint {
    public static int maxPoint1(int[] arr, int l) {
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            int nearest = nearestIndex(arr, i, arr[i] - l);
            res = Math.max(res, i - nearest + 1);
        }
        return res;
    }

    public static int nearestIndex(int[] arr, int r, int value) {
        int l = 0;
        int index = r;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return index;

    }

    public static int maxPoint2(int[] arr, int l) {
        int left = 0;
        int right = 0;
        int N = arr.length;
        int max = 0;
        while (right < N) {
            while (right <N && arr[right] - arr[left] <= l) {
                right++;
            }
            max = Math.max(max, right - (left++));

        }
        return max;
    }

}
